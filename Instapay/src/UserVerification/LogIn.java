package UserVerification;
import UserInterface.InstapaySystem;
import UserProfile.User;

public class LogIn {
    private static void loadUser(User u) {
        InstapaySystem.curUser = u;
    }
    public static boolean signIn(String username, String password) {
        User user = InstapaySystem.databaseAccessLayer.searchUser(username, password);
        if (user != null) {
            loadUser(user);
            return true;
        } else {
            return false;
        }
    }
//    public static boolean signIn(User user) {
//        boolean foundUser = InstapaySystem.databaseAccessLayer.searchUser(user);
//        if (foundUser) {
//            loadUser(user);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
