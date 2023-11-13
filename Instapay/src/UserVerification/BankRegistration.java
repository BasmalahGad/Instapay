package UserVerification;

import UserInterface.InstapaySystem;
import UserProfile.User;

public class BankRegistration extends Registration {
    @Override
    public boolean foundUser(User user) {
        // should be more generic
        AuthenticationService authenticationService = new FaisalBank();
        return authenticationService.authenticate(user);
    }
}
