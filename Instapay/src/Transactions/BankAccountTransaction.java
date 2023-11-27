package Transactions;

import Connections.BankAPI;
import UserInterface.InstapaySystem;
import UserProfile.BankAccount;

public class BankAccountTransaction extends Transaction {
    BankAPI bankAPI;
    String cardNumber;
    public BankAccountTransaction(BankAPI bankAPI, String cardNumber, double amount) {
        this.bankAPI = bankAPI;
        this.cardNumber = cardNumber;
        super.setAmount(amount);
    }

    @Override
    public void send() {
        bankAPI.deposit(cardNumber, bankAPI.getBalance(cardNumber) + getAmount());
    }
}
