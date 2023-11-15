package Connections;

public interface WalletAPI {
    public double getBalance(String mobile);
    public boolean verifyMobile(String mobile);
    public void deposit(String mobile, double amount);
}
class WalletAPIAcc{
    private String mobile;
    private String password;
    private double balance;
    public WalletAPIAcc(String mobile, String password, double balance)
    {
        this.mobile = mobile; this.balance = balance; this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
