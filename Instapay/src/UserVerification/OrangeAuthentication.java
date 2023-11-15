package UserVerification;

import Connections.OrangeAPI;
import UserProfile.User;
import UserProfile.WalletAccount;

public class OrangeAuthentication implements WalletAuthentication {
    @Override
    public boolean authenticate(User user) {
        OrangeAPI orangeAPI = new OrangeAPI();
        return orangeAPI.verifyMobile(((WalletAccount)user.getAccount()).getPhoneNumber());
    }
}
