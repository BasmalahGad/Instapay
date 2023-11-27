package Transactions;

import Connections.BankAPI;
import Connections.WalletAPI;
import UserInterface.InstapaySystem;
import UserProfile.BankAccount;


public class BankTransactionMethod extends TransactionMethod{
    private BankAccount bankAccount;
    private BankAPI bankAPI;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAPI getBankAPI() {
        return bankAPI;
    }

    public void setBankAPI(BankAPI bankAPI) {
        this.bankAPI = bankAPI;
        initialize();
    }

    public BankTransactionMethod() {

    }

    private void initialize(){
        bankAccount = (BankAccount) InstapaySystem.curUser.getAccount();
        super.setBalance(bankAPI.getBalance(bankAccount.getCreditCardNumber()));
    }
    @Override
    public boolean createWalletTransaction(WalletAPI walletAPI, String mobile, double amount){
        if(getBalance() >= amount && walletAPI.verifyMobile(mobile)){
            Transaction mobileTransaction = new MobileTransaction(walletAPI, mobile, amount);
            this.bankAPI.deposit(bankAccount.getCreditCardNumber(), super.getBalance() - amount);
            mobileTransaction.send();
            return true;
        }return false;
    }

    public boolean createBankAccountTransaction(BankAPI bankAPI, String cardNumber, double amount){
        if(super.getBalance() >= amount && bankAPI.verifyCardNum(cardNumber)){
            Transaction bankTransaction = new BankAccountTransaction(bankAPI, cardNumber, amount);
            this.bankAPI.deposit(bankAccount.getCreditCardNumber(), super.getBalance() - amount);
            bankTransaction.send();
            return true;
        }
        return false;
    }
}
