package Transactions;

import Connections.BankAPI;
import UserInterface.InstapaySystem;
import UserProfile.BankAccount;

public class BankAccountContext extends Context{
    private BankAccount bankAccount;
    private BankAPI bankAPI;
    public BankAccountContext() {
        bankAccount = (BankAccount) InstapaySystem.curUser.getInstapayProfile().getAccount();
        super.setBalance(bankAPI.getBalance(bankAccount.getCreditCardNumber()));
    }

    @Override
    public void payBill() throws Exception {
        if(super.getBalance() >= super.getBillService().getBill().getAmount()){
            bankAPI.deposit(bankAccount.getCreditCardNumber(), super.getBalance() - super.getBillService().getBill().getAmount());
            super.getBillService().deduct();
        }else{
            throw new Exception();
        }
    }
}
