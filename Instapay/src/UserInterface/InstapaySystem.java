package UserInterface;
import Connections.*;
import Database.Database;
import Transactions.*;
import UserProfile.*;
import UserVerification.*;

import java.util.*;
public class InstapaySystem {
    public static User curUser = null;
    public static boolean signIn(String username, String password) {
        return AuthenticationService.signIn(username, password);
    }
    public static boolean signUpBank(String name, String mobile, String email, String username, String password,
                              String creditCardNumber, String creditCardPassword, String bankName) {
        Account account = new BankAccount(creditCardNumber, creditCardPassword);
        User user = new User(name, mobile, email, username, password, account);
        ProviderAuthentication providerAuthentication = null;
        if (Objects.equals(bankName, "FAISAL")) {
            providerAuthentication = (ProviderAuthentication) new FaisalAuthentication();
            ((BankAccount)user.getAccount()).setBankName(BankName.FAISAL);
        } else if (Objects.equals(bankName, "CIB")) {
            providerAuthentication = (ProviderAuthentication) new CIBAuthentication();
            ((BankAccount)user.getAccount()).setBankName(BankName.CIB);
        }
        else{
            return false;
        }
        return Registration.signUp(user, providerAuthentication) ;
    }
    public static boolean signUpWallet(String name, String mobile, String email, String username, String password,
                                String walletNumber, String walletPassword, String walletProvider) {
        Account account = new WalletAccount(walletNumber, walletPassword);
        User user = new User(name, mobile, email, username, password, account);
        ProviderAuthentication providerAuthentication = null;
        if (Objects.equals(walletProvider, "VODAFONE")) {
            providerAuthentication = (ProviderAuthentication) new VodafoneAuthentication();
            ((WalletAccount)user.getAccount()).setWalletProvider(WalletProvider.VODAFONE);
        } else if (Objects.equals(walletProvider, "ORANGE")) {
            providerAuthentication = (ProviderAuthentication) new OrangeAuthentication();
            ((WalletAccount)user.getAccount()).setWalletProvider(WalletProvider.ORANGE);

        } else {
            return false;
        }
        return Registration.signUp(user, providerAuthentication);
    }


    public static boolean payBill(String billNum, String billType){
        BillPaymentMethod billPaymentMethod = null;
        if(InstapaySystem.curUser.getAccount() instanceof BankAccount){
            billPaymentMethod = new BankAccountBillPaymentMethod();
            if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals(BankName.FAISAL)){
                ((BankAccountBillPaymentMethod)billPaymentMethod).setBankAPI(new FaisalAPI());
            }else if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals(BankName.CIB)){
                ((BankAccountBillPaymentMethod)billPaymentMethod).setBankAPI(new CIBAPI());
            }
        }else if (InstapaySystem.curUser.getAccount() instanceof WalletAccount){
            billPaymentMethod = new WalletBillPaymentMethod();
            if(((WalletAccount)InstapaySystem.curUser.getAccount()).getWalletProvider().equals(WalletProvider.VODAFONE)){
                ((WalletBillPaymentMethod)billPaymentMethod).setWalletAPI(new VodafoneAPI());
            }else if(((WalletAccount)InstapaySystem.curUser.getAccount()).getWalletProvider().equals(WalletProvider.ORANGE)){
                ((WalletBillPaymentMethod)billPaymentMethod).setWalletAPI(new OrangeAPI());
            }
        }
        switch (billType){
            case "1":{
                billPaymentMethod.setBillService(new GasBillService(billNum));
                break;
            }case "2":{
                billPaymentMethod.setBillService(new WaterBillService(billNum));
                break;
            }case "3":{
                billPaymentMethod.setBillService(new ElectricityBillService(billNum));
                break;
            }
        }
        return billPaymentMethod.payBill();
    }

    public static boolean sendMoneyMobile(String walletProvider, String mobile, double amount){
        TransactionMethod transactionMethod = null;
        if(curUser.getAccount() instanceof BankAccount){
            transactionMethod = new BankTransactionMethod();
            if (((BankAccount)curUser.getAccount()).getBankName().equals(BankName.FAISAL)){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new FaisalAPI());
            }else if (((BankAccount)curUser.getAccount()).getBankName().equals(BankName.CIB)){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new CIBAPI());
            }

        }else if (curUser.getAccount() instanceof WalletAccount){
            if(mobile.equals(((WalletAccount)curUser.getAccount()).getPhoneNumber())) return false;
            transactionMethod = new WalletTransactionMethod();
            if(((WalletAccount)curUser.getAccount()).getWalletProvider().equals(WalletProvider.VODAFONE)){
                ((WalletTransactionMethod)transactionMethod).setWalletAPI(new VodafoneAPI());
            }else if(((WalletAccount)curUser.getAccount()).getWalletProvider().equals(WalletProvider.ORANGE)){
                ((WalletTransactionMethod)transactionMethod).setWalletAPI(new OrangeAPI());
            }
        }
        try{
            if(walletProvider.equals("VODAFONE")){
                transactionMethod.createWalletTransaction(new VodafoneAPI(), mobile, amount);
            }else if (walletProvider.equals("ORANGE")){
                transactionMethod.createWalletTransaction(new OrangeAPI(), mobile, amount);
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }
    public static boolean sendMoneyBank(String bankName, String cardNum, double amount){
        TransactionMethod transactionMethod = null;
        if(curUser.getAccount() instanceof BankAccount){
            if(cardNum.equals(((BankAccount)curUser.getAccount()).getCreditCardNumber())) return false;
            transactionMethod = new BankTransactionMethod();
            if (((BankAccount)curUser.getAccount()).getBankName().equals(BankName.FAISAL)){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new FaisalAPI());
            }else if (((BankAccount)curUser.getAccount()).getBankName().equals(BankName.CIB)){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new CIBAPI());
            }
        }
        try{
            if(bankName.equals("CIB")){
                ((BankTransactionMethod)transactionMethod).createBankAccountTransaction(new CIBAPI(), cardNum, amount);
            }else if (bankName.equals("FAISAL")){
                ((BankTransactionMethod)transactionMethod).createBankAccountTransaction(new FaisalAPI(), cardNum, amount);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public static User loadUser(String username){
        Database database = new Database();
        return (database.contain(username));
    }

    public static double inquireBalance(){
        if(curUser.getAccount() instanceof BankAccount){
            if (((BankAccount)curUser.getAccount()).getBankName().equals(BankName.FAISAL)){
                return new FaisalAPI().getBalance(((BankAccount) curUser.getAccount()).getCreditCardNumber());
            }else if (((BankAccount)curUser.getAccount()).getBankName().equals(BankName.CIB)){
                return new CIBAPI().getBalance(((BankAccount) curUser.getAccount()).getCreditCardNumber());
            }
        }else if (curUser.getAccount() instanceof WalletAccount){
            if (((WalletAccount)curUser.getAccount()).getWalletProvider().equals(WalletProvider.ORANGE)){
                return new OrangeAPI().getBalance(((WalletAccount) curUser.getAccount()).getPhoneNumber());
            }else if (((WalletAccount)curUser.getAccount()).getWalletProvider().equals(WalletProvider.VODAFONE)){
                return new VodafoneAPI().getBalance(((WalletAccount) curUser.getAccount()).getPhoneNumber());
            }
        }
        return 0.0;
    }
}
