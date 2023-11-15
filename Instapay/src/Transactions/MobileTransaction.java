package Transactions;

import Connections.WalletAPI;
import UserInterface.InstapaySystem;
import UserProfile.WalletAccount;

public class MobileTransaction extends Transaction {
    private WalletAPI walletAPI;
    private String mobile;

    public MobileTransaction(WalletAPI walletAPI, String mobile, double amount) {
        this.walletAPI = walletAPI;
        this.mobile = mobile;
        super.setAmount(amount);
    }

    @Override
    public void send() {
        WalletAccount walletAccount = (WalletAccount) InstapaySystem.curUser.getInstapayProfile().getAccount();
        double balance = walletAPI.getBalance(walletAccount.getPhoneNumber());
        walletAPI.deposit(walletAccount.getPhoneNumber(), balance - getAmount());
        walletAPI.deposit(mobile, walletAPI.getBalance(mobile) + getAmount());
    }
}
