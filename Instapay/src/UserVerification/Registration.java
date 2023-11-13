package UserVerification;
import Database.Database;
import Database.DatabaseAccessLayer;
import UserInterface.InstapaySystem;
import UserProfile.User;

public abstract class Registration {
    public boolean signUp(User user) {
        DatabaseAccessLayer DB = new Database();
        if (foundUser(user)) {
            //to verify strong username and password
            //verify(user);
            DB.addNewUser(user);
            return true;
        } else {
            return false;
        }
    }
    abstract boolean foundUser(User user);
}
