package UserInterface;
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
}
