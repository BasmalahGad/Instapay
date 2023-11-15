package Transactions;

public abstract class BillPaymentMethod {
    private BillService billService;
    private double balance;
    public BillService getBillService() {
        return billService;
    }

    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract boolean payBill();
}
