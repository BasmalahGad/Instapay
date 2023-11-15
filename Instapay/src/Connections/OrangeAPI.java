package Connections;

import UserProfile.WalletAccount;

import java.util.ArrayList;
import java.util.Objects;


public class OrangeAPI implements WalletAPI{
    public static ArrayList<WalletAccount> accounts;
    public OrangeAPI()
    {
        accounts = new ArrayList<>();
        addFakeAccounts();
    }

    @Override
    public boolean verifyMobile(String ID) {
        for (WalletAccount account : accounts) {
            if (Objects.equals(account.getPhoneNumber(), ID))
                return true;
        }
        return false;    }
    @Override
    public double getBalance(String ID) {
        for (WalletAccount account : accounts) {
            if (Objects.equals(account.getPhoneNumber(), ID))
                return account.getBalance();
        }
        return 0;
    }

    @Override
    public void deposit(String ID, double amount) {
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
        WalletAccount walletAccount = new WalletAccount("01000000000", "1010");
        walletAccount.setBalance(1000);
        accounts.add(walletAccount);
        walletAccount.setBalance(2000);
        accounts.add(walletAccount);
        walletAccount.setBalance(3000);
        accounts.add(walletAccount);
    }
}
