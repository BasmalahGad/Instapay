package UserVerification;

import Connections.FaisalAPI;
import UserProfile.User;

public class FaisalBankAuthentication implements AuthenticationService {
    @Override
    public boolean authenticate(User user) {
        return FaisalAPI.checkExistUser(user);
    }
}
