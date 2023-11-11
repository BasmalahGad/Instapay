package UserInterface;

import Database.*;
import UserProfile.*;
import UserVerification.*;

import java.util.Objects;
import java.util.Scanner;

public class InstapaySystem {
    public static DatabaseAccessLayer database = new Database();
    public static User curUser = new User();
    public boolean signIn() {
        System.out.println("Please Enter Your Username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Please Enter Your Password:");
        String password = scanner.nextLine();

        return LogIn.signIn(username, password);
    }
    public boolean signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Name:");
        String name = scanner.nextLine();
        System.out.println("Please Enter Your Mobile:");
        String mobile = scanner.nextLine();
        System.out.println("Please Enter Your Email:");
        String email = scanner.nextLine();
        System.out.println("Please Enter Your Username:");
        String username = scanner.nextLine();
        System.out.println("Please Enter Your Password:");
        String password = scanner.nextLine();
        System.out.println("Bank or Wallet?");
        String service = scanner.nextLine();
        User user = new User (name, mobile, email, username, password);
//        AuthenticationService authenticationService = null;
//        if (Objects.equals(service, "Bank"))
//            authenticationService = new FaisalBank();
//        else
//            authenticationService = new WeWallet();

        Registration registration = null;
        if (Objects.equals(service, "Bank"))
            registration = new BankRegistration();
        else
            registration = new WalletRegistration();
        return registration.signUp(user);
    }
}
