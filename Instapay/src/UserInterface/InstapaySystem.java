package UserInterface;
import Connections.FaisalAPI;
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
        if (Objects.equals(bankName, "Faisal")) {
            providerAuthentication = new FaisalAuthentication();
            return Registration.signUp(user, providerAuthentication);
        } else if (Objects.equals(bankName, "CIB")) {
            // dummy till we have a cib class
            return false;
        } else {
            // dummy as well
            return true;
        }
    }
    public static boolean signUpWallet(String name, String mobile, String email, String username, String password,
                                String walletNumber, String walletPassword, String walletProvider) {
        Account account = new WalletAccount(walletNumber, walletPassword);
        User user = new User(name, mobile, email, username, password, account);
        ProviderAuthentication providerAuthentication = null;
        if (Objects.equals(walletProvider, "Vodafone")) {
            providerAuthentication = new FaisalAuthentication();
            return Registration.signUp(user, providerAuthentication);
        } else if (Objects.equals(walletProvider, "Orange")) {
            // dummy till we have an orange class
            return false;
        } else {
            // dummy as well
            return true;
        }
    }


    public static boolean payBill(String billNum, String billType){
        BillPaymentMethod billPaymentMethod = null;
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

        if(InstapaySystem.curUser.getAccount() instanceof BankAccount){
            billPaymentMethod = new BankAccountBillPaymentMethod();
            if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals("Faisal")){
                ((BankAccountBillPaymentMethod)billPaymentMethod).setBankAPI(new FaisalAPI());
            }else if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals("CIB")){
                ((BankAccountBillPaymentMethod)billPaymentMethod).setBankAPI(new CIBAPI());
            }
        }else if (InstapaySystem.curUser.getAccount() instanceof WalletAccount){
            billPaymentMethod = new WalletBillPaymentMethod();
            if(((WalletAccount)InstapaySystem.curUser.getAccount()).getWalletProvider().equals("Vodafone")){
                ((WalletBillPaymentMethod)billPaymentMethod).setWalletAPI(new VodafoneAPI());
            }else if(((WalletAccount)InstapaySystem.curUser.getAccount()).getWalletProvider().equals("Orange")){
                ((WalletBillPaymentMethod)billPaymentMethod).setWalletAPI(new OrangeAPI());
            }
        }

        try{
            billPaymentMethod.payBill();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean sendMoneyMobile(String walletProvider, String mobile, double amount){
        TransactionMethod transactionMethod = null;
        if(InstapaySystem.curUser.getAccount() instanceof BankAccount){
            transactionMethod = new BankTransactionMethod();
            if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals("Faisal")){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new FaisalAPI());
            }else if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals("CIB")){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new CIBAPI());
            }

        }else if (InstapaySystem.curUser.getAccount() instanceof WalletAccount){
            transactionMethod = new WalletTransactionMethod();
            if(((WalletAccount)InstapaySystem.curUser.getAccount()).getWalletProvider().equals("Vodafone")){
                ((WalletTransactionMethod)transactionMethod).setWalletAPI(new VodafoneAPI());
            }else if(((WalletAccount)InstapaySystem.curUser.getAccount()).getWalletProvider().equals("Orange")){
                ((WalletTransactionMethod)transactionMethod).setWalletAPI(new OrangeAPI());
            }
        }
        try{
            if(walletProvider.equals("Vodafone")){
                transactionMethod.createWalletTransaction(new VodafoneAPI(), mobile, amount);
            }else if (walletProvider.equals("Orange")){
                transactionMethod.createWalletTransaction(new OrangeAPI(), mobile, amount);
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }
    public static boolean sendMoneyBank(String bankName, String cardNum, double amount){
        TransactionMethod transactionMethod = null;
        if(InstapaySystem.curUser.getAccount() instanceof BankAccount){
            transactionMethod = new BankTransactionMethod();
            if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals("Faisal")){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new FaisalAPI());
            }else if (((BankAccount)InstapaySystem.curUser.getAccount()).getBankName().equals("CIB")){
                ((BankTransactionMethod)transactionMethod).setBankAPI(new CIBAPI());
            }
        }
        try{
            if(bankName.equals("CIB")){
                ((BankTransactionMethod)transactionMethod).createBankAccountTransaction(new CIBAPI(), cardNum, amount);
            }else if (bankName.equals("Faisal")){
                ((BankTransactionMethod)transactionMethod).createBankAccountTransaction(new FaisalAPI(), cardNum, amount);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public static User loadUser(String username){
        Database database = new Database();
        return database.contain(username);
    }
}
