package Connections;


import java.util.ArrayList;
import java.util.Objects;

public class CIBAPI implements BankAPI{
    public ArrayList<BankAPIAcc> accounts;
    public CIBAPI()
    {
        accounts = new ArrayList<>();
        addFakeAccounts();
    }
    @Override
    public boolean verifyCardNum(String ID) {
        for (BankAPIAcc account : accounts) {
            if (Objects.equals(account.getCreditCardNum(), ID))
                return true;
        }
        return false;
    }
    @Override
    public double getBalance(String ID) {
        for (BankAPIAcc account : accounts) {
            if (Objects.equals(account.getCreditCardNum(), ID))
                return account.getBalance();
        }
        return 0;
    }

    @Override
    public void deposit(String ID, double amount) {
        for (BankAPIAcc account : accounts) {
            if (Objects.equals(account.getCreditCardNum(), ID))
            {
                account.setBalance(amount);
                return;
            }
        }
    }

    private void addFakeAccounts()
    {
        BankAPIAcc BankAPIAcc = new BankAPIAcc("1111 2222 3333 4444", "1234",1000);
        accounts.add(BankAPIAcc);
        BankAPIAcc = new BankAPIAcc("2222 3333 4444 5555", "1234",1000);
        accounts.add(BankAPIAcc);
        BankAPIAcc = new BankAPIAcc("3333 4444 5555 6666", "1234",1000);
        accounts.add(BankAPIAcc);
    }

}

