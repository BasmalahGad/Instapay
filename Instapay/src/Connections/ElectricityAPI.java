package Connections;

import Transactions.ElectricityBill;
import Transactions.WaterBill;

import java.util.ArrayList;
import java.util.Objects;

public class ElectricityAPI implements BillAPI{
    private static boolean fake = false;
    public static ArrayList<ElectricityBill> bills = new ArrayList<>();;
    public ElectricityAPI()
    {
        if (!fake){
        addFakeBills();
        fake = true;
        }
    }

    @Override
    public boolean searchBill(String billNum) {
        for (ElectricityBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                return true;
        }
        return false;
    }

    @Override
    public double getAmount(String billNum) {
        for (ElectricityBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                return bill.getAmount();
        }
        return 0;
    }

    @Override
    public void pay(String billNum) {
        for (ElectricityBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                bill.setAmount(0);
        }
    }
    private void addFakeBills()
    {
        for (int i = 0; i < 5; i++) {
            ElectricityBill bill = new ElectricityBill();
            bill.setAmount(10 + i * 2);
            bill.setID("10" + String.valueOf(i));
            bills.add(bill);
        }
    }
}
