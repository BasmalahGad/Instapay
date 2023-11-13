package UserInterface;
import UserProfile.*;
import UserVerification.*;
import java.util.*;
public class InstapaySystem {
    public static User curUser = null;
    public boolean signIn() {
        //This should be in GUI
        System.out.println("Please Enter Your Username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Please Enter Your Password:");
        String password = scanner.nextLine();

        return LogIn.signIn(username, password);
    }
    public boolean signUp() {
        //This should be in GUI
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

        OTP otp = new OTP();
        System.out.println(otp.generateOTP());
        System.out.println("Enter the OTP sent:");
        String inOtp = scanner.nextLine();
        if (otp.verifyOTP(inOtp)) {
            Registration registration = null;
            AuthenticationService authenticationService = null;
            return registration.signUp(user, authenticationService);
        } else {
            // how will we handle the wrong otp? start the process over? or give the user another chance?
            // what will be returned here to distinguish between the false returned from the otp and the one from signup
            System.out.println("Wrong OTP");
            return false;
        }


//        AuthenticationService authenticationService = null;
//        if (Objects.equals(service, "Bank"))
//            authenticationService = new FaisalBank();
//        else
//            authenticationService = new WeWallet();

//        Registration registration = null;
//        AuthenticationService authenticationService = null;
//        if (Objects.equals(service, "Bank"))
//            registration = new BankRegistration();
//        else
//            registration = new WalletRegistration();
    }
}
