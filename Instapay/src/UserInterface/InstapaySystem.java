package UserInterface;
import Connections.FaisalAPI;
import Transactions.*;
import UserProfile.*;
import UserVerification.*;

import java.util.*;
public class InstapaySystem {
    public static User curUser = null;
    public boolean signIn(String username, String password) {
        return AuthenticationService.signIn(username, password);
    }
    public boolean signUpBank(String name, String mobile, String email, String username, String password,
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
    public boolean signUpWallet(String name, String mobile, String email, String username, String password,
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





    public void chooseService(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Service:");
        String service = scanner.nextLine();
        switch (service){
            case "Pay bill":{
                System.out.println("1- Gas \n 2- Electricity \n 3- Water \n");
                String billType = scanner.nextLine();
                Bill bill = null;
                switch (billType){
                    case "Gas": {
                        bill = new GasBill();
                        break;
                    }case "Electricity": {
                        bill = new ElectricityBill();
                        break;
                    }case "Water": {
                        bill = new WaterBill();
                        break;
                    }
                }
                payBill(bill);
                break;
            } case "Send Money":{
                System.out.println("to: \n 1- Bank Account \n 2- Mobile");
                String transactionType = scanner.nextLine();
                Transaction transaction = null;
                String id;
                switch (transactionType){
                    case "Bank Account": {
                        System.out.println("Please enter credit card number: ");
                        id = scanner.nextLine();
                        transaction = new BankAccountTransaction(new FaisalAPI());
                        break;
                    }case "Mobile": {
                        System.out.println("Please mobile number: ");
                        id = scanner.nextLine();
                        transaction = new MobileTransaction();
                        break;
                    }
                }
                sendMoney(transaction, id);
                break;
            }
        }
    }

    public void payBill(Bill bill){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter el 3adad ID:");
        String id = scanner.nextLine();
        bill.create();
        bill.deduct();

    }

    public boolean sendMoney(Transaction transaction, String id){

        return false;
    }
}
