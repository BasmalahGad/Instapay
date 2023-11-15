package Connections;


import java.util.ArrayList;
import java.util.Objects;


public class VodafoneAPI implements WalletAPI{
    public static ArrayList<WalletAPIAcc> accounts;
    public VodafoneAPI()
    {
        accounts = new ArrayList<>();
        addFakeAccounts();
    }

    @Override
    public boolean verifyMobile(String ID) {
        for (WalletAPIAcc account : accounts) {
            if (Objects.equals(account.getMobile(), ID))
                return true;
        }
        return false;    }
    @Override
    public double getBalance(String ID) {
        for (WalletAPIAcc account : accounts) {
            if (Objects.equals(account.getMobile(), ID))
                return account.getBalance();
        }
        return 0;
    }

    @Override
    public void deposit(String ID, double amount) {
        for (WalletAPIAcc account : accounts) {
            if (Objects.equals(account.getMobile(), ID))
            {
                account.setBalance(amount);
                return;
            }
        }
    }

    private void addFakeAccounts()
    {
        WalletAPIAcc WalletAPIAcc = new WalletAPIAcc("01000000000", "1010", 1000);
        accounts.add(WalletAPIAcc);
        WalletAPIAcc = new WalletAPIAcc("01010000000", "1010", 1000);
        accounts.add(WalletAPIAcc);
        WalletAPIAcc = new WalletAPIAcc("01001000000", "1010", 1000);
        accounts.add(WalletAPIAcc);
    }
}
