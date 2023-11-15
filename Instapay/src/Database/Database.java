package Database;

import UserProfile.User;

import java.util.ArrayList;

public class Database implements DatabaseAccessLayer{
    private static ArrayList<User> users = new ArrayList<>();
    public Database(){

    }

    @Override
    public boolean addNewUser(User user) {
        return users.add(user);
    }

    @Override
    public User searchUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    @Override
    public User contain(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }


    @Override
    public boolean removeAccount(User user) {
        if(users.contains(user) )
        {
            int i = users.indexOf(user);
            users.get(i).setAccount(null);
            return true;
        }
        return false;
    }


//    @Override
//    public boolean removeInstapayProfile(User user) {
//        if(users.contains(user) )
//        {
//            int i = users.indexOf(user);
//            users.get(i).setInstapayProfile(null);
//            return true;
//        }
//        return false;
//    }
}
