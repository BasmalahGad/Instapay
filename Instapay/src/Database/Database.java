package Database;

import UserProfile.*;


import java.util.ArrayList;

public class Database implements DatabaseAccessLayer{
    private static boolean fake = false;
    private static ArrayList<User> users = new ArrayList<>();
    public Database(){
        if (!fake){
            addFakeUsers();
            fake = true;
        }
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

    private void addFakeUsers()
    {
        BankAccount account = new BankAccount("3333 4444 5555 6666", "3456");
        account.setBankName(BankName.valueOf("FAISAL"));
        User user = new User("s","01000000000","s@gmail.com","sss","sss@S1",account);
        users.add(user);

        BankAccount account2 = new BankAccount("2222 3333 4444 5555", "2345");
        account2.setBankName(BankName.valueOf("FAISAL"));
        User user2 = new User("s","01000000000","s@gmail.com","fff","sss@S1",account2);
        users.add(user2);

        WalletAccount account3 = new WalletAccount("01001000000", "1010");
        account3.setWalletProvider(WalletProvider.valueOf("VODAFONE"));
        User user3 = new User("s","01000000000","s@gmail.com","vvv","sss@S1",account3);
        users.add(user3);

        WalletAccount account4 = new WalletAccount("01200000000", "1010");
        account4.setWalletProvider(WalletProvider.valueOf("ORANGE"));
        User user4 = new User("s","01200000000","s@gmail.com","ooo","sss@S1",account4);
        users.add(user4);
    }

}
