package Transactions;

import Connections.ElectricityAPI;

public class ElectricityBillService extends BillService{
    public ElectricityBillService(String billNum) {
        super(new ElectricityAPI(), billNum);
    }

    @Override
    public void create() throws Exception {
        if(super.getBillAPI().searchBill(super.getBillNum())){
            super.setBill(new ElectricityBill());
            super.getBill().setAmount(super.getBillAPI().getAmount(super.getBillNum()));
        }else{
            throw new Exception();
        }
    }

    @Override
    public void deduct() {

    }
}
