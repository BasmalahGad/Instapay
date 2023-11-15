package UserVerification;

import Connections.WeAPI;
import UserProfile.User;

public class WeAuthentication implements WalletAuthentication {
    @Override
    public boolean authenticate(User user) {
        // how to implement this
        return WeAPI.verifyMobile(user.getInstapayProfile().getAccount().getMobile());
    }
}
