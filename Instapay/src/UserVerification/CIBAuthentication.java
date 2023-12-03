package UserVerification;

import Connections.CIBAPI;
import UserProfile.BankAccount;
import UserProfile.User;

public class CIBAuthentication implements ProviderAuthentication {
    @Override
    public boolean authenticate(User user) {
        CIBAPI CIBAPI = new CIBAPI();
        return CIBAPI.verifyCardNum(((BankAccount)user.getAccount()).getCreditCardNumber());
    }
}
