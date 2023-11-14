package Connections;

import Transactions.WaterBill;

import java.util.ArrayList;
import java.util.Objects;

public class WaterAPI implements BillAPI{

    public static ArrayList<WaterBill> bills;
    public WaterAPI()
    {
        bills = new ArrayList<>();
        addFakeBills();
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
            if(Objects.equals(bill.getID(), ID))
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
        WaterBill bill = new WaterBill();
        bill.setID("1234");
        bill.setAmount(100);
        bills.add(bill);
        bill.setID("2345");
        bill.setAmount(200);
        bills.add(bill);
        bill.setID("3456");
        bill.setAmount(300);
        bills.add(bill);
        bill.setID("4567");
        bill.setAmount(400);
        bills.add(bill);
    }
}
