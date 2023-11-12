package UserVerification;
import Database.DatabaseAccessLayer;
import UserInterface.InstapaySystem;
import UserProfile.User;

public abstract class Registration {
    public boolean signUp(User user) {
        if (foundUser()) {
            //to verify strong username and password
            //verify(user);
            InstapaySystem.database.addNewUser(user);
            return true;
        } else {
            return false;
        }
    }
    abstract boolean foundUser();
}
