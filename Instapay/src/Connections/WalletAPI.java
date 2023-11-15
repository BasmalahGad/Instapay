package Connections;

public interface WalletAPI {
    public double getBalance(String mobile);
    public boolean verifyMobile(String mobile);
    public void deposit(String mobile, double amount);
}
