package Connections;

import Transactions.WaterBill;

import java.util.ArrayList;
import java.util.Objects;

public class WaterAPI implements API{

    public static ArrayList<WaterBill> bills;
    public WaterAPI()
    {
        bills = new ArrayList<>();
        addFakeBills();
    }

    @Override
    public boolean search(String ID) {
        for (WaterBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                return true;
        }
        return false;
    }

    @Override
    public double read(String ID) {
        for (WaterBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                return bill.getAmount();
        }
        return 0;
    }

    @Override
    public void write(String ID, double amount) {
        for (WaterBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                bill.setAmount(amount);
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
