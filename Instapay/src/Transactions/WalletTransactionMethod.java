package Transactions;

import Connections.WalletAPI;
import UserInterface.InstapaySystem;
import UserProfile.WalletAccount;

public class WalletTransactionMethod extends TransactionMethod{
    private WalletAccount walletAccount;

    public WalletTransactionMethod(WalletAPI walletAPI) {
        this.walletAccount =  (WalletAccount) InstapaySystem.curUser.getInstapayProfile().getAccount();
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
