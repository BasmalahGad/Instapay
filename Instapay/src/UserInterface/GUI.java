package UserInterface;

import UserProfile.BankAccount;
import UserProfile.BankName;
import UserProfile.WalletAccount;
import UserProfile.WalletProvider;
import UserVerification.OTP;

import java.util.Objects;
import java.util.Scanner;

public class GUI {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welcome to our Instapay Application!");
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose the number of operation you want to do:");
            System.out.println("1. Sign Up\n2. Sign In\n");
            String option = scanner.nextLine();
            switch (option) {
                case "1": {
                    String nameRegex = "^[A-Za-z\\s]+$";
                    System.out.println("Please Enter Your Name:");
                    String name = scanner.nextLine();
                    while (!name.matches(nameRegex)) {
                        System.out.println("Please Enter a valid Name:");
                        name = scanner.nextLine();
                    }
                    String phoneRegex = "^0(10|11|12)\\d{8}$";
                    System.out.println("Please Enter Your Mobile:");
                    String mobile = scanner.nextLine();
                    while (!mobile.matches(phoneRegex)) {
                        System.out.println("Please Enter a valid mobile:");
                        mobile = scanner.nextLine();
                    }

                    OTP otp = new OTP();
                    String genOtp = otp.generateOTP();
                    // fake send otp
                    System.out.println(genOtp);
                    System.out.println("Enter the OTP sent:");
                    String inOtp = scanner.nextLine();
                    while (!otp.verifyOTP(inOtp, genOtp)) {
                        System.out.println("Enter a valid OTP:");
                        inOtp = scanner.nextLine();
                    }
                    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                    System.out.println("Please Enter Your Email:");
                    String email = scanner.nextLine();
                    while (!email.matches(emailRegex)) {
                        System.out.println("Please Enter a valid email:");
                        email = scanner.nextLine();
                    }
                    System.out.println("Please Enter Your Username:");
                    String username = scanner.nextLine();
                    String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\-!@#$%^&*_=+/.?<>]).{8,20}$";
                    System.out.println("Please Enter Your Password:");
                    String password = scanner.nextLine();
                    while (!password.matches(passwordRegex)) {
                        System.out.println("Your password should have:");
                        System.out.println("1. At least one lowercase letter.\n" +
                                "2. At least one uppercase letter.\n" +
                                "3. At least one digit.\n" +
                                "4. Minimum length of 8 characters." +
                                "5. Maximum length of 20 characters.");
                        System.out.println("Please Enter a Valid Password:");
                        password = scanner.nextLine();
                    }
                    System.out.println("Register Using:\n1. Bank Account\n2. Wallet Number");
                    String option2 = scanner.nextLine();
                    while (!option2.equals("1") && !option2.equals("2")) {
                        System.out.println("Enter a valid option :");
                        System.out.println("Register Using:\n1. Bank Account\n2. Wallet Number");
                        option2 = scanner.nextLine();
                    }
                    switch (option2) {
                        case "1": {
                            System.out.println("Please Choose a Bank Name:\n1. Faisal Bank\n2. CIB");
                            String bankNameCh = scanner.nextLine();
                            while (!bankNameCh.equals("1") && !bankNameCh.equals("2")) {
                                System.out.println("Enter a valid option:");
                                System.out.println("Please Choose a Bank Name:\n1. Faisal Bank\n2. CIB");
                                bankNameCh = scanner.nextLine();
                            }
                            boolean flag = false;
                            while (!flag) {
                                System.out.println("Please Enter Your Credit Card Number:");
                                String creditCardNumber = scanner.nextLine();
                                System.out.println("Please Enter Your Credit Card Password:");
                                String creditCardPassword = scanner.nextLine();
                                String bankName = null;
                                switch (bankNameCh) {
                                    case "1": {
                                        bankName = "FAISAL";
                                        break;
                                    }
                                    case "2": {
                                        bankName = "CIB";
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid Option!");
                                        break;
                                    }
                                }
                                boolean registered = InstapaySystem.signUpBank(name, mobile, email, username, password, creditCardNumber, creditCardPassword, bankName);
                                if (registered) {
                                    System.out.println("Successful Registration!");
                                    InstapaySystem.signIn(username, password);
                                    loggedInUserOptions();
                                    flag = true;
                                } else {
                                    System.out.println("Unable to Register!");
                                }
                            }
                            break;
                        }
                        case "2": {
                            System.out.println("Please Choose a Wallet Provider:\n1. Orange\n2. Vodafone");
                            String walletProviderCh = scanner.nextLine();
                            while (!walletProviderCh.equals("1") && !walletProviderCh.equals("2")) {
                                System.out.println("Enter a valid option:");
                                System.out.println("Please Choose a Wallet Provider:\n1. Orange\n2. Vodafone");
                                walletProviderCh = scanner.nextLine();
                            }
                            boolean flag = false;
                            while (!flag) {
                                System.out.println("Please Enter Your Wallet Number:");
                                String walletNumber = scanner.nextLine();
                                System.out.println("Please Enter Your Wallet Password:");
                                String walletPassword = scanner.nextLine();
                                String walletProvider = null;
                                switch (walletProviderCh) {
                                    case "1": {
                                        walletProvider = "ORANGE";
                                        break;
                                    }
                                    case "2": {
                                        walletProvider = "VODAFONE";
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid Option!");
                                        break;
                                    }
                                }
                                boolean registered = InstapaySystem.signUpWallet(name, mobile, email, username, password, walletNumber, walletPassword, walletProvider);
                                if (registered) {
                                    System.out.println("Successful Registration!");
                                    InstapaySystem.signIn(username, password);
                                    loggedInUserOptions();
                                    flag = true;
                                } else {
                                    System.out.println("Unable to Register!");
                                }
                            }
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
                    boolean flag = false;
                    while (!flag) {
                        System.out.println("Please Enter Your Username:");
                        String username = scanner.nextLine();
                        System.out.println("Please Enter Your Password:");
                        String password = scanner.nextLine();
                        boolean signedIn = InstapaySystem.signIn(username, password);
                        if (signedIn) {
                            System.out.println("Signed in successfully!");
                            loggedInUserOptions();
                            flag = true;
                        } else {
                            System.out.println("Unable to sign in!");
                        }
                    }
                    break;
                }
                case "3": {
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("Invalid Option!");
                    break;
                }
            }
        }
    }


    private void loggedInUserOptions() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Please Choose The Service You Want: ");
            System.out.println("1. Pay Bill\n2. Transfer Money");
            String service = scanner.nextLine();
            while (!service.equals("1") && !service.equals("2")) {
                System.out.println("Enter a valid option :");
                System.out.println("1. Pay Bill\n2. Transfer Money");
                service = scanner.nextLine();
            }
            switch (service) {
                case "1": {
                    String billNum;
                    System.out.println("1. Gas Bill\n2. Water Bill\n3. Electricity Bill");
                    String billType = scanner.nextLine();
                    while (!billType.equals("1") && !billType.equals("2") && !billType.equals("3")) {
                        System.out.println("Enter a valid option:");
                        System.out.println("1. Gas Bill\n2. Water Bill\n3. Electricity Bill");
                        billType = scanner.nextLine();
                    }
                    System.out.println("Please Enter Bill Number: ");
                    billNum = scanner.nextLine();
                    boolean paid = InstapaySystem.payBill(billNum, billType);
                    if (paid) {
                        System.out.println("Successful Payment :)");
                    } else {
                        System.out.println("You Do not Have Enough Money to Pay This Bill");
                        continue;
                    }
                    break;

                }
                case "2": {
                    boolean bank = false;

                    System.out.println("1. Transfer to Wallet\n2. Transfer to Instapay Account");
                    if (InstapaySystem.curUser.getAccount() instanceof BankAccount) {
                        System.out.println("3. Transfer to Bank Account");
                        bank = true;
                    }
                    String transOption = scanner.nextLine();
                    while (!bank && !transOption.equals("1") && !transOption.equals("2")) {
                        System.out.println("Enter a valid option :");
                        System.out.println("1. Transfer to Wallet\n2. Transfer to Instapay Account");
                        transOption = scanner.nextLine();
                    }
                    while (bank && !transOption.equals("1") && !transOption.equals("2") && !transOption.equals("3")) {
                        System.out.println("Enter a valid option:");
                        System.out.println("1. Transfer to Wallet\n2. Transfer to Instapay Account");
                        System.out.println("3. Transfer to Bank Account");
                        transOption = scanner.nextLine();
                    }
                    Double amount;
                    switch (transOption) {
                        case "1": {
                            System.out.println("Please Choose a Wallet Provider:\n1. Orange\n2. Vodafone");
                            String walletProvider = scanner.nextLine();
                            while (!walletProvider.equals("1") && !walletProvider.equals("2")) {
                                System.out.println("Enter a valid option :");
                                System.out.println("Please Choose a Wallet Provider:\n1. Orange\n2. Vodafone");
                                walletProvider = scanner.nextLine();
                            }
                            String phoneRegex = "^0(10|11|12)\\d{8}$";
                            System.out.println("Please Enter Receiver Mobile Number: ");
                            String mobile = scanner.nextLine();
                            while (!mobile.matches(phoneRegex)) {
                                System.out.println("Please Enter a valid mobile:");
                                mobile = scanner.nextLine();
                            }
                            System.out.println("Please Enter The Amount You Want to Transfer: ");
                            amount = scanner.nextDouble();
                            while (amount.isNaN()){
                                System.out.println("Please Enter a valid Amount:");
                                amount = scanner.nextDouble();
                            }
                            boolean transferred = InstapaySystem.sendMoneyMobile(walletProvider, mobile, amount);
                            if (transferred) {
                                System.out.println("Successful Transferring :)");
                            } else {
                                System.out.println("Failed to Transfer!");
                                continue;
                            }
                            break;
                        }
                        case "2": {
                            System.out.println("Please Enter Receiver Username: ");
                            String username = scanner.nextLine();
                            System.out.println("Please Enter The Amount You Want to Transfer: ");
                            amount = scanner.nextDouble();
                            while (amount.isNaN()){
                                System.out.println("Please Enter a valid Amount:");
                                amount = scanner.nextDouble();
                            }
                            boolean transferred = true;
                            if (InstapaySystem.loadUser(username).getAccount() instanceof BankAccount && InstapaySystem.curUser.getAccount() instanceof BankAccount) {
                                String bankName = null;
                                if (((BankAccount) InstapaySystem.loadUser(username).getAccount()).getBankName().equals("FAISAL")) {
                                    bankName = "FAISAL";
                                } else if (((BankAccount) InstapaySystem.loadUser(username).getAccount()).getBankName().equals("CIB")) {
                                    bankName = "CIB";
                                }
                                transferred = InstapaySystem.sendMoneyBank(bankName, username, amount);
                            } else if (InstapaySystem.loadUser(username).getAccount() instanceof WalletAccount) {
                                String walletProvider = null;
                                if (((WalletAccount) InstapaySystem.curUser.getAccount()).getWalletProvider().equals("VODAFONE")) {
                                    walletProvider = "VODAFONE";
                                } else if (((WalletAccount) InstapaySystem.curUser.getAccount()).getWalletProvider().equals("ORANGE")) {
                                    walletProvider = "ORANGE";
                                }
                                transferred = InstapaySystem.sendMoneyMobile(walletProvider, username, amount);
                            } else {
                                System.out.println("You Can Not Transfer to Bank Account");
                                continue;
                            }
                            if (transferred) {
                                System.out.println("Successful Transferring :)");
                            } else {
                                System.out.println("Failed to Transfer!");
                                continue;
                            }
                            break;
                        }
                        case "3": {
                            System.out.println("Please Choose a Bank Name:\n1. Faisal Bank\n2. CIB");
                            String bankName = scanner.nextLine();
                            while (!bankName.equals("1") && !bankName.equals("2")) {
                                System.out.println("Enter a valid option :");
                                System.out.println("Please Choose a Bank Name:\n1. Faisal Bank\n2. CIB");
                                bankName = scanner.nextLine();
                            }
                            System.out.println("Please Enter Receiver Credit Card Number: ");
                            String cardNum = scanner.nextLine();
                            System.out.println("Please Enter The Amount You Want to Transfer: ");
                            amount = scanner.nextDouble();
                            while (amount.isNaN()){
                                System.out.println("Please Enter a valid Amount:");
                                amount = scanner.nextDouble();
                            }
                            boolean transferred = InstapaySystem.sendMoneyBank(bankName, cardNum, amount);
                            if (transferred) {
                                System.out.println("Successful Transferring :)");
                            } else {
                                System.out.println("Failed to Transfer!");
                                continue;
                            }
                            break;
                        }default: {
                            System.out.println("Invalid Option!");
                            break;
                        }
                    }
                }
                case "3": {
                    System.out.println("Your Balance: ");
                    System.out.println(InstapaySystem.inquireBalance());
                    break;
                }
                case "4": {
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("Invalid Option!");
                    break;
                }
            }
        }
    }
}
