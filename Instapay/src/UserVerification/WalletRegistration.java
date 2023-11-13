package UserVerification;

import UserProfile.User;

public class WalletRegistration extends Registration {
    @Override
    public boolean foundUser(User user) {
        // should be more generic
        AuthenticationService authenticationService = new WeWallet();
        return authenticationService.authenticate(user);
    }
}
