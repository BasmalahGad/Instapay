package Connections;

import UserProfile.WalletAccount;

import java.util.ArrayList;


public class WeAPI implements WalletAPI{
    private ArrayList<WalletAccount> accounts;


    public WeAPI()
    {
        accounts = new ArrayList<>();
    }
    @Override
    public void connect() {

    }
    private void addFackAccounts()
    {
        WalletAccount walletAccount = new WalletAccount();
        walletAccount.setBalance(1000);
        accounts.add(walletAccount);
        walletAccount.setBalance(2000);
        accounts.add(walletAccount);
        walletAccount.setBalance(3000);
        accounts.add(walletAccount);
    }

    public ArrayList<WalletAccount> getAccounts() {
        return accounts;
    }
}
