package UserVerification;

import Connections.FaisalAPI;
import Connections.WeAPI;
import UserProfile.User;

public class FaisalAuthentication implements BankAuthentication {
    @Override
    public boolean authenticate(User user) {
        // how to implement this
        return FaisalAPI.verifyBankNum(user.getCreditCardNumber());
    }
}
