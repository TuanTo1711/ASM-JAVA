package assignment.giaidoan2.staff;

public class Marketing extends Staff {
    private double sales, commission;

    public Marketing() {
    }

    public Marketing(String ID, String name, double pay, double sales, double commission) {
        super("Tiep thi", ID, name, pay);
        this.sales = sales;
        this.commission = commission;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
    
    public void insert() {
        super.insert();
        setType("Tiep thi");
        System.out.print("\nNhap Doanh So(San pham): ");
        setSales(input.nextDouble());
        System.out.print("\nNhap Hue Hong(%): ");
        setCommission(input.nextDouble());
        setPay(getPay() + (getSales() * getCommission()));
    }
    
    public void display() {
        System.out.printf("- ID[%s]\t- %s\t- %s\t- Luong : %s trieu\t- Thue: %s\t - Doanh So: %s\t- Doanh So: %s\t- Tong thu nhap: %s ", 
                                getID(), getType(), getName(), getPay(), getThueThuNhap(), getSales(), getCommission(), getThuNhap());
    }
}
