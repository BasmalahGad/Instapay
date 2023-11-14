package UserVerification;
import Database.Database;
import Database.DatabaseAccessLayer;
import UserProfile.User;

public class Registration {
    public static boolean signUp(User user, ProviderAuthentication providerAuthentication) {
        DatabaseAccessLayer database = new Database();
        String username = user.getUsername();
        if (providerAuthentication.authenticate(user) && (database.contain(username) != null)) {
            //to verify strong username and password
            //verify(user);
            database.addNewUser(user);
            return true;
        } else {
            return false;
        }
    }
}
