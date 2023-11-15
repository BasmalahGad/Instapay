package Transactions;

import Connections.ElectricityAPI;
import Connections.WaterAPI;

public class WaterBillService extends BillService{
    public WaterBillService(String billNum) {
        super(new WaterAPI(), billNum);
    }

    @Override
    public void create() throws Exception {
        if(super.getBillAPI().searchBill(super.getBillNum())){
            super.setBill(new WaterBill());
            super.getBill().setAmount(super.getBillAPI().getAmount(super.getBillNum()));
        }else{
            throw new Exception();
        }
    }

}
