package UserVerification;

import Connections.VodafoneAPI;
import UserProfile.User;
import UserProfile.WalletAccount;

public class VodafoneAuthentication implements WalletAuthentication {
    @Override
    public boolean authenticate(User user) {
        VodafoneAPI VodafoneAPI = new VodafoneAPI();
        return VodafoneAPI.verifyMobile(((WalletAccount)user.getAccount()).getPhoneNumber());
    }
}
