package Connections;

import Transactions.GasBill;

import java.util.ArrayList;
import java.util.Objects;

public class GasAPI implements BillAPI{

    public static ArrayList<GasBill> bills;
    public GasAPI()
    {
        bills = new ArrayList<>();
        addFakeBills();
    }

    @Override
    public boolean searchBill(String billNum) {
        for (GasBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                return true;
        }
        return false;
    }

    @Override
    public double getAmount(String billNum) {
        for (GasBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                return bill.getAmount();
        }
        return 0;
    }

    @Override
    public void pay(String billNum) {
        for (GasBill bill: bills)
        {
            if(Objects.equals(bill.getID(), billNum))
                bill.setAmount(0);
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
