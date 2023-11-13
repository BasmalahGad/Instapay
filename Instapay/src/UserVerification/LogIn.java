package UserVerification;
import Database.Database;
import Database.DatabaseAccessLayer;
import UserInterface.InstapaySystem;
import UserProfile.User;

public class LogIn {
    private static void loadUser(User u) {
        InstapaySystem.curUser = u;
    }
    public static boolean signIn(String username, String password) {
        DatabaseAccessLayer Db = new Database();
        User user = Db.searchUser(username, password);
        if (user != null) {
            loadUser(user);
            return true;
        } else {
            return false;
        }
    }
}
