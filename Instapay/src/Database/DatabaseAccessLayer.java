package Database;

import UserProfile.User;

public interface DatabaseAccessLayer {

    boolean addNewUser(User user);

    public User searchUser(String username, String password);
    public User contain(String username);
}
