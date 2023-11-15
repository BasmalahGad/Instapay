package Database;

import UserProfile.User;

import java.util.ArrayList;
import java.util.Objects;

public class Database implements DatabaseAccessLayer{
    private static ArrayList<User> users;
    public Database(){
        users = new ArrayList<>();
    }

    @Override
    public boolean addNewUser(User user) {
        return users.add(user);
    }

    @Override
    public User searchUser(String username, String password) {
        for (User user : users) {
            if (user.getInstapayProfile().getUserName() == username && user.getInstapayProfile().getPassword() == password)
                return user;
        }
        return null;
    }

    @Override
    public User contain(String username) {
        for (User user : users) {
            if (Objects.equals(user.getInstapayProfile().getUserName(), username))
                return user;
        }
        return null;
    }


    @Override
    public boolean removeAccount(User user) {
        if(users.contains(user) )
        {
            int i = users.indexOf(user);
            users.get(i).getInstapayProfile().setAccount(null);
            return true;
        }
        return false;
    }


    @Override
    public boolean removeInstapayProfile(User user) {
        if(users.contains(user) )
        {
            int i = users.indexOf(user);
            users.get(i).setInstapayProfile(null);
            return true;
        }
        return false;
    }
}
