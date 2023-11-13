package UserInterface;
import UserProfile.*;
import UserVerification.*;
import java.util.*;
public class InstapaySystem {
    public static User curUser = null;
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
        User user = new User (name, mobile, email);


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
