package assignment.giaidoan2.application;

import java.util.Scanner;
import assignment.giaidoan2.staff.StaffList;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static StaffList list = new StaffList();
    
    public static void display() {
        input = new Scanner(System.in);
        System.out.println("\n------------------------------------------------------------"
                        + "\n0. Thoat chuong trinh."
                        + "\n1. NHAP SACH SACH NHAN VIEN TU BAN PHIM"
                        + "\n2. XUAT DANH SACH NHAN VIEN RA MAN HINH"
                        + "\n3. TIM VA HIEN THI NHAN VIEN THEO MA NHAP TU BAN PHIM"
                        + "\n4. XOA NHAN VIEN THEO MA NHAP TU BAN PHIM"
                        + "\n5. CAP NHAT THONG TIN NHAN VIEN THEO MA NHAP TU BAN PHIM"
                        + "\n6. TIM CAC NHAN VIEN THEO KHOANG LUONG NHAP TU BAN PHIM"
                        + "\n7. SAP XEP NHAN VIEN THEO HO VA TEN"
                        + "\n8. SAP XEP NHAN VIEN THEO THU NHAP"
                        + "\n9. XUAT 5 NHAN VIEN CO THU NHAP CAO NHAT"
                        + "\n------------------------------------------------------------");
        run();
    }

    public static void run() {
        String chon;
        do {
            System.out.print("Chon chuc nang (nhap so 0 - 9): ");
            chon = input.nextLine();
        } while (!chon.matches("^[0-9]+$"));
        int num = Integer.parseInt(chon);;
        String ID;
        switch (num) {
            case 1:
                System.out.println("Xin moi nhap danh sach nhan vien");
                list.addList();
                break;
            case 2:
                System.out.println("Danh sach nhan vien la: ");
                list.showList();
                break;
            case 3:
                ID = new String();
                do {
                    input = new Scanner(System.in);
                    System.out.print("Nhap ma nhan vien can tim: ");
                    ID = input.nextLine();
                } while (ID == null);
                list.findStaff(ID);
                break;
            case 4:
                ID = new String();
                do {
                    input = new Scanner(System.in);
                    System.out.print("Nhap ma nhan vien muon xoa: ");
                    ID = input.nextLine();
                } while (ID == null);
                list.deleteStaff(ID);
                System.out.println("Danh sach sau khi xoa la: ");
                list.showList();
                break;
            case 5:
                ID = new String();
                do {
                    System.out.print("Nhap ma nhan vien muon cap nhat: ");
                    ID = input.nextLine();
                } while (ID == null);
                list.updateStaff(ID);
                System.out.println("Danh sach sau khi cap nhat la: ");
                list.showList();
                break;
            case 6:
                double begin;
                double end;
                do {
                    input = new Scanner(System.in);
                    System.out.println("Nhap du lieu (dau khoang < cuoi khoang va >= 0)");
                    System.out.print("\nNhap dau khoang: ");
                    begin = input.nextDouble();
                    System.out.print("\nNhap cuoi khoang: ");
                    end = input.nextDouble();
                } while (((begin < 0) || (end < 0) || (begin > end)) && (begin != end));
                System.out.println("Danh sach nhan vien trong khoang tu " + begin + " - " + end + " la: ");
                list.findPay(begin, end);
                break;
            case 7:
                list.sortName();
                System.out.println("Danh sach sau khi sap xep la: ");
                list.showList();
                break;
            case 8:
                list.sortPay();
                System.out.println("Danh sach sau khi sap xep la: ");
                list.showList();
                break;
            case 9:
                System.out.println("Top 5 la: ");
                list.showTop5();
                break;
            default:
                System.out.println("KHONG CO CHUC NANG NAY!" + "\nVUI LONG CHON LAI!");
                run();
                break;
        }
        input = new Scanner(System.in);
        System.out.print("\nNhan phim bat ky de tiep tuc thuc hien chuc nang. Nhan phim 0 de thoat chuong trinh: ");
        if(input.nextLine().equals("0")) {
            System.out.println("\nChuong trinh da ket thuc!");
            System.exit(0);
        }
        display();
    }
}