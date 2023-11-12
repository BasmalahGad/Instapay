package UserVerification;

import Connections.FaisalAPI;
import UserProfile.User;

public class FaisalBank implements BankAuthentication {
    @Override
    public boolean authenticate(User user) {
        return FaisalAPI.checkExistUser(user);
    }
}
