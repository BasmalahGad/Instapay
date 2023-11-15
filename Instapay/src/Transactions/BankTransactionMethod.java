package Transactions;

import Connections.BankAPI;
import Connections.WalletAPI;
import UserInterface.InstapaySystem;
import UserProfile.BankAccount;


public class BankTransactionMethod extends TransactionMethod{
    private BankAccount bankAccount;
    public BankTransactionMethod(BankAPI bankAPI) {
        bankAccount = (BankAccount) InstapaySystem.curUser.getInstapayProfile().getAccount();
        super.setBalance(bankAPI.getBalance(bankAccount.getCreditCardNumber()));
    }

    @Override
    public void createWalletTransaction(WalletAPI walletAPI, String mobile, double amount) throws Exception {
        if(getBalance() >= amount && walletAPI.verifyMobile(mobile)){
            Transaction mobileTransaction = new MobileTransaction(walletAPI, mobile, amount);
            mobileTransaction.send();
        }else{
            throw new Exception();
        }
    }

    public void createBankAccountTransaction(BankAPI bankAPI, String cardNumber, double amount) throws Exception {
        if(super.getBalance() >= amount && bankAPI.verifyCardNum(cardNumber)){
            Transaction bankTransaction = new BankAccountTransaction(bankAPI, cardNumber, amount);
            bankTransaction.send();
        }else{
            throw new Exception();
        }

    }
}
