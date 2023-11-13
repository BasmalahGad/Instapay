package UserVerification;
import Database.Database;
import Database.DatabaseAccessLayer;
import UserInterface.InstapaySystem;
import UserProfile.User;

public class Registration {
    public boolean signUp(User user, AuthenticationService authenticationService) {
        DatabaseAccessLayer database = new Database();
        String username = user.getInstapayProfile().getUserName();
        if (authenticationService.authenticate(user) && !database.contain(username)) {
            //to verify strong username and password
            //verify(user);
            database.addNewUser(user);
            return true;
        } else {
            return false;
        }
    }
}
