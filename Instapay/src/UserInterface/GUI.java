package UserInterface;

import Database.Database;
import Transactions.*;
import UserProfile.BankAccount;
import UserProfile.BankName;
import UserProfile.WalletAccount;
import UserProfile.WalletProvider;
import UserVerification.OTP;

import javax.management.MBeanAttributeInfo;
import java.util.Scanner;

public class GUI {
    private Scanner scanner = new Scanner(System.in);
    public void run() {
        System.out.println("Welcome to our Instapay Application!");
        System.out.println("Choose the number of operation you want to do:");
        System.out.println("1. Sign Up\n2. Sign In\n");
        String option = scanner.nextLine();
        switch (option) {
            case "1": {
                System.out.println("Please Enter Your Name:");
                String name = scanner.nextLine();
                System.out.println("Please Enter Your Mobile:");
                String mobile = scanner.nextLine();

                OTP otp = new OTP();
                String genOtp = otp.generateOTP();
                // fake send otp
                System.out.println(genOtp);
                System.out.println("Enter the OTP sent:");
                String inOtp = scanner.nextLine();
                if (!otp.verifyOTP(inOtp, genOtp)) {
                    // handle if wrong otp was entered (break, while loop, give a second chance ...?)
                }

                System.out.println("Please Enter Your Email:");
                String email = scanner.nextLine();
                System.out.println("Please Enter Your Username:");
                String username = scanner.nextLine();
                System.out.println("Please Enter Your Password:");
                String password = scanner.nextLine();
                System.out.println("Register Using:\n1. Bank Account\n2. Wallet Number");
                String option2 = scanner.nextLine();
                switch (option2) {
                    case "1": {
                        System.out.println("Please Choose a Bank Name:\n1. Faisal Bank\n2. CIB");
                        String bankNameCh = scanner.nextLine();
                        System.out.println("Please Enter Your Credit Card Number:");
                        String creditCardNumber = scanner.nextLine();
                        System.out.println("Please Enter Your Credit Card Password:");
                        String creditCardPassword = scanner.nextLine();
                        String bankName = null;
                        switch (bankNameCh){
                            case "1":{
                                bankName = "FAISAL";
                                break;
                            } case "2":{
                                bankName = "CIB";
                                break;
                            }default: {
                                System.out.println("Invalid Option!");
                                break;
                            }
                        }
                        boolean registered = InstapaySystem.signUpBank(name, mobile, email, username, password, creditCardNumber, creditCardPassword, bankName);
                        if (registered) {
                            System.out.println("Successful Registration!");
                            InstapaySystem.signIn(username , password);
                            loggedInUserOptions();
                        }else
                            System.out.println("Unable to Register!");
                        break;
                    }
                    case "2": {
                        System.out.println("Please Choose a Wallet Provider:\n1. Orange\n2. Vodafone");
                        String walletProviderCh = scanner.nextLine();
                        System.out.println("Please Enter Your Wallet Number:");
                        String walletNumber = scanner.nextLine();
                        System.out.println("Please Enter Your Wallet Password:");
                        String walletPassword = scanner.nextLine();
                        String walletProvider = null;
                        switch (walletProviderCh){
                            case "1":{
                                walletProvider = "ORANGE";
                                break;
                            } case "2":{
                                walletProvider = "VODAFONE";
                                break;
                            }default: {
                                System.out.println("Invalid Option!");
                                break;
                            }
                        }
                        boolean registered = InstapaySystem.signUpWallet(name, mobile, email, username, password, walletNumber, walletPassword, walletProvider);
                        if (registered) {
                            System.out.println("Successful Registration!");
                            InstapaySystem.signIn(username, password);
                            loggedInUserOptions();
                        }else
                            System.out.println("Unable to Register!");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Option!");
                        break;
                    }
                }
                break;
            }
            case "2": {
                System.out.println("Please Enter Your Username:");
                String username = scanner.nextLine();
                System.out.println("Please Enter Your Password:");
                String password = scanner.nextLine();
                boolean signedIn = InstapaySystem.signIn(username, password);
                if (signedIn) {
                    System.out.println("Signed in successfully!");
                    loggedInUserOptions();
                } else {
                    System.out.println("Unable to sign in!");
                }
                break;
            }
            default: {
                System.out.println("Invalid Option!");
                break;
            }
        }
    }


    private void loggedInUserOptions(){
        System.out.println("Please Choose The Service You Want: ");
        System.out.println("1. Pay Bill\n2. Transfer Money");
        String service = scanner.nextLine();
        switch (service){
            case "1":{
                String billNum;
                System.out.println("1. Gas Bill\n2. Water Bill\n3. Electricity Bill");
                String billType = scanner.nextLine();
                if(!billType.equals("1") && !billType.equals("2") && !billType.equals("3")){
                    System.out.println("Invalid Option!");
                    return;
                }
                System.out.println("Please Enter Bill Number: ");
                billNum = scanner.nextLine();
                boolean paid = InstapaySystem.payBill(billNum, billType);
                if(!paid){
                    System.out.println("You Do not Have Enough Money to Pay This Bill");
                }
                break;
            } case "2":{
                System.out.println("1. Transfer to Wallet\n2. Transfer to Instapay Account");
                if(InstapaySystem.curUser.getAccount() instanceof BankAccount){
                    System.out.println("3. Transfer to Bank Account");
                }
                String transOption = scanner.nextLine();
                double amount;
                switch (transOption){
                    case "1": {
                        System.out.println("Please Choose a Wallet Provider:\n1. Orange\n2. Vodafone");
                        String walletProvider = scanner.nextLine();
                        System.out.println("Please Enter Receiver Mobile Number: ");
                        String mobile = scanner.nextLine();
                        System.out.println("Please Enter The Amount You Want to Transfer: ");
                        amount = scanner.nextDouble();
                        boolean transferred = InstapaySystem.sendMoneyMobile(walletProvider, mobile, amount);
                        if(!transferred){
                            System.out.println("You Do not Have Enough Money to Transfer");
                        }
                        break;
                    }case "2": {
                        System.out.println("Please Enter Receiver Username: ");
                        String username = scanner.nextLine();
                        System.out.println("Please Enter The Amount You Want to Transfer: ");
                        amount = scanner.nextDouble();
                        boolean transferred = true;
                        if (InstapaySystem.loadUser(username).getAccount() instanceof BankAccount && InstapaySystem.curUser.getAccount() instanceof BankAccount){
                            String bankName = null;
                            if(((BankAccount) InstapaySystem.loadUser(username).getAccount()).getBankName().equals(BankName.FAISAL)){
                                bankName = "FAISAL";
                            }else if (((BankAccount) InstapaySystem.loadUser(username).getAccount()).getBankName().equals(BankName.CIB)){
                                bankName = "CIB";
                            }
                            transferred = InstapaySystem.sendMoneyBank(bankName, username, amount);
                        }else if (InstapaySystem.loadUser(username).getAccount() instanceof WalletAccount) {
                            String walletProvider = null;
                            if (((WalletAccount) InstapaySystem.curUser.getAccount()).getWalletProvider().equals(WalletProvider.VODAFONE)) {
                                walletProvider = "VODAFONE";
                            } else if (((WalletAccount) InstapaySystem.curUser.getAccount()).getWalletProvider().equals(WalletProvider.ORANGE)) {
                                walletProvider = "ORANGE";
                            }
                            transferred = InstapaySystem.sendMoneyMobile(walletProvider, username, amount);
                        }else {
                            System.out.println("You Can Not Transfer to Bank Account");
                            return;
                        }
                        if(!transferred){
                            System.out.println("You Do not Have Enough Money to Transfer");
                        }
                        break;
                    } case "3":{
                        System.out.println("Please Choose a Bank Name:\n1. Faisal Bank\n2. CIB");
                        String bankName = scanner.nextLine();
                        System.out.println("Please Enter Receiver Credit Card Number: ");
                        String cardNum = scanner.nextLine();
                        System.out.println("Please Enter The Amount You Want to Transfer: ");
                        amount = scanner.nextDouble();
                        boolean transferred= InstapaySystem.sendMoneyBank(bankName, cardNum, amount);
                        if(!transferred){
                            System.out.println("You Do not Have Enough Money to Transfer");
                        }
                        break;
                    }default: {
                        System.out.println("Invalid Option!");
                        break;
                    }
                }
                break;
            }
        }
    }
}
