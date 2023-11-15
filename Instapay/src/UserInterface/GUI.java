package UserInterface;

import UserProfile.User;
import UserVerification.OTP;
import UserVerification.ProviderAuthentication;
import UserVerification.Registration;

import java.util.Scanner;

public class GUI {
    InstapaySystem instapaySystem = new InstapaySystem();
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Instapay Application!");
        System.out.println("Choose the number of operation you want to do:");
        System.out.println("1. Sign Up\n2.Sign In\n");
        int option = scanner.nextInt();
        switch (option) {
            case 1: {
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
                option = scanner.nextInt();
                switch (option) {
                    case 1: {
                        System.out.println("Please Choose a Bank Name:\n1. Faisal Bank\n2. CIB");
                        String bankName = scanner.nextLine();
                        System.out.println("Please Enter Your Credit Card Number:");
                        String creditCardNumber = scanner.nextLine();
                        System.out.println("Please Enter Your Credit Card Password:");
                        String creditCardPassword = scanner.nextLine();

                        boolean registered = instapaySystem.signUpBank(name, mobile, email, username, password, creditCardNumber, creditCardPassword, bankName);
                        if (registered)
                            System.out.println("Successful Registration!");
                        else
                            System.out.println("Unable to Register!");
                        break;
                    }
                    case 2: {
                        System.out.println("Please Choose a Wallet Provider:\n1. Orange\n2. Vodafone");
                        String walletProvider = scanner.nextLine();
                        System.out.println("Please Enter Your Wallet Number:");
                        String walletNumber = scanner.nextLine();
                        System.out.println("Please Enter Your Wallet Password:");
                        String walletPassword = scanner.nextLine();
                        boolean registered = instapaySystem.signUpWallet(name, mobile, email, username, password, walletNumber, walletPassword, walletProvider);
                        if (registered)
                            System.out.println("Successful Registration!");
                        else
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
            case 2: {
                System.out.println("Please Enter Your Username:");
                String username = scanner.nextLine();
                System.out.println("Please Enter Your Password:");
                String password = scanner.nextLine();
                boolean signedIn = instapaySystem.signIn(username, password);
                if (signedIn) {
                    System.out.println("Signed in successfully!");
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
}
