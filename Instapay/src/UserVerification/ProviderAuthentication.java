package UserVerification;

import UserProfile.User;

public interface ProviderAuthentication {
    public boolean authenticate(User user);
}
