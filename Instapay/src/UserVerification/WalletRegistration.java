package UserVerification;

public class WalletRegistration extends Registration {
    @Override
    public boolean foundUser() {
        // should be more generic
        AuthenticationService authenticationService = new WeWallet();
        return authenticationService.authenticate(user);
    }
}
