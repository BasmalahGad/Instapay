package Connections;

public interface BillAPI {
    public double getAmount(String billNum);
    public boolean searchBill(String billNum);
    public void pay(String billNum);

}
