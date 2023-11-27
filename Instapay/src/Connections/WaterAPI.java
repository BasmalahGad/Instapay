package Connections;

import Transactions.GasBill;
import Transactions.WaterBill;

import java.util.ArrayList;
import java.util.Objects;

public class WaterAPI implements BillAPI{
    private static boolean fake = false;
    public static ArrayList<WaterBill> bills = new ArrayList<>();
    public WaterAPI()
    {
        if (!fake){
            addFakeBills();
            fake = true;
        }
    }

    @Override
    public boolean searchBill(String billNum) {
        for (WaterBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                return true;
        }
        return false;
    }

    @Override
    public double getAmount(String billNum) {
        for (WaterBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                return bill.getAmount();
        }
        return 0;
    }

    @Override
    public void pay(String billNum) {
        for (WaterBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                bill.setAmount(0);
        }
    }
    private void addFakeBills()
    {
        for (int i = 0; i < 5; i++) {
            WaterBill bill = new WaterBill();
            bill.setAmount(10 + i * 2);
            bill.setID("10" + String.valueOf(i));
            bills.add(bill);
        }
    }
}
