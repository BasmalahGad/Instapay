package Connections;

public interface API {
    public boolean search(String ID);
    public double read(String ID);
    public void write(String ID, double amount);
}
