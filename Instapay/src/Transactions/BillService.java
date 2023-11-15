package Transactions;

import Connections.BillAPI;

public abstract class BillService {
    private Bill bill;
    private BillAPI billAPI;
    private String billNum;

    public BillService(BillAPI billAPI, String billNum) {
        this.billAPI = billAPI;
        this.billNum = billNum;
    }
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public BillAPI getBillAPI() {
        return billAPI;
    }

    public void setBillAPI(BillAPI billAPI) {
        this.billAPI = billAPI;
    }
    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }
    public void deduct() {
        bill.setAmount(0);
    }
    public abstract void create() throws Exception;

}
