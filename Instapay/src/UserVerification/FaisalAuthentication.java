package UserVerification;

import Connections.FaisalAPI;
import UserProfile.BankAccount;
import UserProfile.User;

public class FaisalAuthentication implements ProviderAuthentication {
    @Override
    public boolean authenticate(User user) {
        FaisalAPI faisalAPI = new FaisalAPI();
        return faisalAPI.verifyCardNum(((BankAccount)user.getAccount()).getCreditCardNumber());
    }
}
