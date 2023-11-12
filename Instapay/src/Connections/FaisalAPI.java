package Connections;

import UserProfile.Account;
import UserProfile.BankAccount;

import java.util.ArrayList;

public class FaisalAPI implements BankAPI{
    private ArrayList<BankAccount> accounts;
    public FaisalAPI()
    {
        accounts = new ArrayList<>();
        addFakeAccounts();
    }
    @Override
    public void connect() {

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

    /**
     * @return accounts
     */
    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
}
