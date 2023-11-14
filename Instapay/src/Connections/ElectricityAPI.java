package Connections;

import Transactions.ElectricityBill;
import Transactions.GasBill;

import java.util.ArrayList;
import java.util.Objects;

public class ElectricityAPI implements API{

    public static ArrayList<ElectricityBill> bills;
    public ElectricityAPI()
    {
        bills = new ArrayList<>();
        addFakeBills();
    }

    @Override
    public boolean search(String ID) {
        for (ElectricityBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                return true;
        }
        return false;
    }

    @Override
    public double read(String ID) {
        for (ElectricityBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                return bill.getAmount();
        }
        return 0;
    }

    @Override
    public void write(String ID, double amount) {
        for (ElectricityBill bill: bills)
        {
            if(Objects.equals(bill.getID(), ID))
                bill.setAmount(amount);
        }
    }
    private void addFakeBills()
    {
        ElectricityBill bill = new ElectricityBill();
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
