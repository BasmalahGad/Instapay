package UserVerification;

import UserProfile.User;

public interface AuthenticationService {
    public boolean authenticate(User user);
}
