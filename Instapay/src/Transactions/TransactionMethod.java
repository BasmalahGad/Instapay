package Transactions;

import Connections.WalletAPI;

public abstract class TransactionMethod {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void createWalletTransaction(WalletAPI walletAPI, String mobile, double amount) throws Exception;
}
