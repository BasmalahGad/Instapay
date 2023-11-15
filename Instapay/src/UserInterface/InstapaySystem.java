package UserInterface;
import Connections.FaisalAPI;
import Transactions.*;
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
