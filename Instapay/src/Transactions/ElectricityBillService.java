package Transactions;

import Connections.ElectricityAPI;

public class ElectricityBillService extends BillService{
    public ElectricityBillService(String billNum) {
        super(new ElectricityAPI(), billNum);
    }

    @Override
    public boolean create() {
        if(super.getBillAPI().searchBill(super.getBillNum())){
            super.setBill(new ElectricityBill());
            super.getBill().setAmount(super.getBillAPI().getAmount(super.getBillNum()));
            return true;
        }
        return false;
    }

}
