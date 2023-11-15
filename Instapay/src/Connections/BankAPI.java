package Connections;

public interface BankAPI {
    public double getBalance(String cardNum);
    public boolean verifyCardNum(String cardNum);
    public void deposit(String cardNum, double amount);
}
class BankAPIAcc{
    private String creditCardNum;
    private String password;
    private double balance;
    public BankAPIAcc(String creditCardNum, String password, double balance)
    {
        this.creditCardNum = creditCardNum; this.balance = balance; this.password = password;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
