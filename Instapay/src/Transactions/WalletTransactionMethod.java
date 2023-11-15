package Transactions;

import Connections.WalletAPI;
import UserInterface.InstapaySystem;
import UserProfile.WalletAccount;

public class WalletTransactionMethod extends TransactionMethod{
    private WalletAccount walletAccount;
    private WalletAPI walletAPI;

    public WalletAccount getWalletAccount() {
        return walletAccount;
    }

    public void setWalletAccount(WalletAccount walletAccount) {
        this.walletAccount = walletAccount;
    }

    public WalletAPI getWalletAPI() {
        return walletAPI;
    }

    public void setWalletAPI(WalletAPI walletAPI) {
        this.walletAPI = walletAPI;
        initialize();
    }

    public WalletTransactionMethod() {

    }
    private void initialize(){
        this.walletAccount =  (WalletAccount) InstapaySystem.curUser.getAccount();
        super.setBalance(walletAPI.getBalance(walletAccount.getPhoneNumber()));
    }
    @Override
    public void createWalletTransaction(WalletAPI walletAPI, String mobile, double amount) throws Exception {
        if(super.getBalance() >= amount && walletAPI.verifyMobile(mobile)){
            Transaction mobileTransaction = new MobileTransaction(walletAPI, mobile, amount);
            mobileTransaction.send();
        }else{
            throw new Exception();
        }
    }
}
