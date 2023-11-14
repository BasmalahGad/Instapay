package Connections;

import UserProfile.BankAccount;
import UserProfile.WalletAccount;

import java.util.ArrayList;
import java.util.Objects;


public class WeAPI implements  API{
    public static ArrayList<WalletAccount> accounts;
    public WeAPI()
    {
        accounts = new ArrayList<>();
        addFakeAccounts();
    }

    @Override
    public boolean search(String ID) {
        for (WalletAccount account : accounts) {
            if (Objects.equals(account.getPhoneNumber(), ID))
                return true;
        }
        return false;    }
    @Override
    public double read(String ID) {
        for (WalletAccount account : accounts) {
            if (Objects.equals(account.getPhoneNumber(), ID))
                return account.getBalance();
        }
        return 0;
    }

    @Override
    public void write(String ID, double amount) {
        for (WalletAccount account : accounts) {
            if (Objects.equals(account.getPhoneNumber(), ID))
            {
                account.setBalance(amount);
                return;
            }
        }
    }

    private void addFakeAccounts()
    {
        WalletAccount walletAccount = new WalletAccount();
        walletAccount.setBalance(1000);
        accounts.add(walletAccount);
        walletAccount.setBalance(2000);
        accounts.add(walletAccount);
        walletAccount.setBalance(3000);
        accounts.add(walletAccount);
    }
}
