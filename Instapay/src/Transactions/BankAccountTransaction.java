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
        BankAccount bankAccount = (BankAccount) InstapaySystem.curUser.getInstapayProfile().getAccount();
        double balance = bankAPI.getBalance(bankAccount.getCreditCardNumber());
        bankAPI.deposit(bankAccount.getCreditCardNumber(), balance - getAmount());
        bankAPI.deposit(cardNumber, bankAPI.getBalance(cardNumber) + getAmount());
    }
}
