package Transactions;

import Connections.WalletAPI;
import UserInterface.InstapaySystem;
import UserProfile.WalletAccount;

public class MobileTransaction extends Transaction {
    private WalletAPI recevierWalletAPI;
    private String mobile;

    public MobileTransaction(WalletAPI recevierWalletAPI, String mobile, double amount) {
        this.recevierWalletAPI = recevierWalletAPI;
        this.mobile = mobile;
        super.setAmount(amount);
    }

    @Override
    public void send() {
        recevierWalletAPI.deposit(mobile, recevierWalletAPI.getBalance(mobile) + getAmount());
    }
}
