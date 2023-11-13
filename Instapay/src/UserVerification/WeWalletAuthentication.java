package UserVerification;

import Connections.WeAPI;
import UserProfile.User;

public class WeWalletAuthentication implements AuthenticationService {
    @Override
    public boolean authenticate(User user) {
        return WeAPI.checkExistUser(user);
    }
}
