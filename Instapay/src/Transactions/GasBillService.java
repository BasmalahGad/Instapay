package Transactions;

import Connections.GasAPI;

public class GasBillService extends BillService{
    public GasBillService(String billNum) {
        super(new GasAPI(), billNum);
    }

    @Override
    public void create() throws Exception {
        if(super.getBillAPI().searchBill(super.getBillNum())){
            super.setBill(new GasBill());
            super.getBill().setAmount(super.getBillAPI().getAmount(super.getBillNum()));
        }else{
            throw new Exception();
        }
    }

}
