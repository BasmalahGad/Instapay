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
        initialize();
    }

    public BankAccountBillPaymentMethod() {

    }
    private void initialize(){
        bankAccount = (BankAccount) InstapaySystem.curUser.getAccount();
        super.setBalance(bankAPI.getBalance(bankAccount.getCreditCardNumber()));
    }
    @Override
    public boolean payBill() {
        if (super.getBillService().create()) {
            if (super.getBalance() >= super.getBillService().getBill().getAmount()) {
                bankAPI.deposit(bankAccount.getCreditCardNumber(), super.getBalance() - super.getBillService().getBill().getAmount());
                super.getBillService().deduct();
                return true;
            }
        }
        return false;
    }

}
