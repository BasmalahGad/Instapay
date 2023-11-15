package Transactions;

import Connections.BankAPI;
import UserInterface.InstapaySystem;
import UserProfile.BankAccount;

public class BankAccountBillPaymentMethod extends BillPaymentMethod {
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
    }

    public BankAccountBillPaymentMethod() {
        this.bankAPI = bankAPI;
        bankAccount = (BankAccount) InstapaySystem.curUser.getAccount();
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
