package Connections;

import UserProfile.BankAccount;

import java.util.ArrayList;
import java.util.Objects;

public class FaisalAPI implements API{
    public ArrayList<BankAccount> accounts;
    public FaisalAPI()
    {
        accounts = new ArrayList<>();
        addFakeAccounts();
    }
    @Override
    public boolean search(String ID) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getCreditCardNumber(), ID))
                return true;
        }
        return false;
    }
    @Override
    public double read(String ID) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getCreditCardNumber(), ID))
                return account.getBalance();
        }
        return 0;
    }

    @Override
    public void write(String ID, double amount) {
        for (BankAccount account : accounts) {
            if (Objects.equals(account.getCreditCardNumber(), ID))
            {
                account.setBalance(amount);
                return;
            }
        }
    }

    private void addFakeAccounts()
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setCreditCardNumber("1111 2222 3333 4444");
        bankAccount.setCreditCardPassword("1234");
        bankAccount.setBalance(1000);
        accounts.add(bankAccount);
        bankAccount.setCreditCardNumber("2222 3333 4444 5555");
        bankAccount.setCreditCardPassword("2345");
        bankAccount.setBalance(2000);
        accounts.add(bankAccount);
        bankAccount.setCreditCardNumber("3333 4444 5555 6666");
        bankAccount.setCreditCardPassword("3456");
        bankAccount.setBalance(3000);
        accounts.add(bankAccount);
    }

}
