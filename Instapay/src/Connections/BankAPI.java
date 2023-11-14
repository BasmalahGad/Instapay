package Connections;

public interface BankAPI {
    public double getBalance(String cardNum);
    public boolean verifyCardNum(String cardNum);
    public void deposit(String cardNum, double amount);
}
