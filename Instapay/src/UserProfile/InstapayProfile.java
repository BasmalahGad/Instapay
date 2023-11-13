package UserProfile;

import Connections.BankAPI;
import Connections.FaisalAPI;

public class InstapayProfile {
    private String userName;
    private String password;
    private Account account ;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // what is the benefit of it ?

//    public void addAccount(Account account){
//        BankAPI bankAPI = new FaisalAPI();
//        bankAPI.connect();//it should take an account
//        this.account = account;
//    }

    // it will remove the account (bank / wallet ) he has
    // is it required ???
    public void removeAccount(Account account){
        this.account = null;
    }


}
