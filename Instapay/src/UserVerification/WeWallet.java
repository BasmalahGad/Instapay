package UserVerification;

import Connections.WeAPI;
import UserProfile.User;

public class WeWallet implements WalletAuthentication {
    @Override
    public boolean authenticate(User user) {
        return WeAPI.checkExistUser(user);
    }
}
