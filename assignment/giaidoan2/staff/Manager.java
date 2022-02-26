package assignment.giaidoan2.staff;

public class Manager extends Staff{
    private double onusPay;

    public Manager() {
    }
    
    public Manager(String iD, String name, double pay, double onusPay) {
        super("Truong Phong", iD, name, pay);
        this.onusPay = onusPay;
    }

    public double getOnusPay() {
        return onusPay;
    }

    public void setOnusPay(double onusPay) {
        this.onusPay = onusPay;
    }
    
    public void insert() {
        super.insert();
        setType("Truong Phong");
        System.out.print("\nNhap Luong Trach Nhiem: ");
        setOnusPay(input.nextDouble());
        setPay(pay + onusPay);
    }

    public void display() {
        super.display();
        System.out.printf(" - Luong Trach nhiem: %s trieu", getOnusPay());
    }
}