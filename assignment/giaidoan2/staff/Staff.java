package assignment.giaidoan2.staff;

import java.util.Scanner;

public class Staff{
    String type, ID, name;
    double pay;
    
    Scanner input = new Scanner(System.in);

    public Staff() {
    }

    public Staff(String iD, String name, double pay) {
        this.type = "Hanh Chanh";
        this.ID = iD;
        this.name = name;
        this.pay = pay;
    }

    public Staff(String type, String iD, String name, double pay) {
        this.type = type;
        this.ID = iD;
        this.name = name;
        this.pay = pay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }
    
    public void setPay(double pay) {
        this.pay = pay;
    }
    
    public void insert() {
        input = new Scanner(System.in);
        setType(type);
        System.out.print("\nNhap Ma So Nhan Vien: ");
        setID(input.nextLine());
        System.out.print("\nNhap Ten Nhan Vien: ");
        setName(input.nextLine());
        System.out.print("\nNhap Luong Nhan Vien: ");
        setPay(input.nextDouble());
    }

    public double getThuNhap() {
        return getPay() - getThueThuNhap();
    }
    
    public double getThueThuNhap() {
        if(getPay() > 15000) {
            return 0.12;
        }
        else if(getPay() > 9000) {
            return 0.1;
        }
        else {
            return 0;
        }
    }

    public void display() {
        System.out.printf("- ID[%s]\t- %s\t- %s\t- Luong : %s trieu\t- Thue: %s\t - Doanh So: %f\t- Hue hong: %f\t- Tong thu nhap: %s ", 
                                getID(), getType(), getName(), getPay(), getThueThuNhap(), 0.0, 0.0, getThuNhap());
    }
}

