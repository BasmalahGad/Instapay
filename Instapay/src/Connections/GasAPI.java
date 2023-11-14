package Connections;

import Transactions.GasBill;

import java.util.ArrayList;
import java.util.Objects;

public class GasAPI implements API{

    public static ArrayList<GasBill> bills;
    public GasAPI()
    {
        bills = new ArrayList<>();
        addFakeBills();
    }

    @Override
    public boolean search(String ID) {
        for (GasBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                return true;
        }
        return false;
    }

    @Override
    public double read(String ID) {
        for (GasBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                return bill.getAmount();
        }
        return 0;
    }

    @Override
    public void write(String ID, double amount) {
        for (GasBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                bill.setAmount(amount);
        }
    }
    private void addFakeBills()
    {
        GasBill bill = new GasBill();
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
