package Transactions;

import Connections.GasAPI;

public class GasBillService extends BillService{
    public GasBillService(String billNum) {
        super(new GasAPI(), billNum);
    }

    @Override
    public boolean create() {
        if(super.getBillAPI().searchBill(super.getBillNum())){
            super.setBill(new GasBill());
            super.getBill().setAmount(super.getBillAPI().getAmount(super.getBillNum()));
            return true;
        }
        return false;
    }

}
