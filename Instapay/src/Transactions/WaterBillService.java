package Transactions;

import Connections.ElectricityAPI;
import Connections.WaterAPI;

public class WaterBillService extends BillService{
    public WaterBillService(String billNum) {
        super(new WaterAPI(), billNum);
    }

    @Override
    public boolean create() {
        if(super.getBillAPI().searchBill(super.getBillNum())){
            super.setBill(new WaterBill());
            super.getBill().setAmount(super.getBillAPI().getAmount(super.getBillNum()));
            return true;
        }
        return false;
    }

}
