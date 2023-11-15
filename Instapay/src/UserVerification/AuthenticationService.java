package UserVerification;
import Database.Database;
import Database.DatabaseAccessLayer;
import UserInterface.InstapaySystem;
import UserProfile.User;

public class AuthenticationService {
    private static void loadUser(User u) {
        InstapaySystem.curUser = u;
    }
    public static boolean signIn(String username, String password) {
        DatabaseAccessLayer database = new Database();
        User user = database.searchUser(username, password);
        if (user != null) {
            loadUser(user);
            return true;
        } else {
            return false;
        }
    }
    public static void signOut() {
        InstapaySystem.curUser = null;
    }
}
