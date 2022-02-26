package assignment.giaidoan2.staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StaffList {
    ArrayList<Staff> list = new ArrayList<>();
    Scanner input;
    
    //them nhieu nhan vien vao danh sach
    public void addList() {
        String str;
        Staff staff;
        do {
            input = new Scanner(System.in);
            System.out.println("\n0 - Thoat nhap du lieu"
                            + "\n1 - Nhan vien hanh chinh"
                            + "\n2 - Nhan vien tiep thi"
                            + "\n3 - Truong Phong");
            do {
                input = new Scanner(System.in);
                System.out.print("\nChon chuc vu cua nhan vien (nhap so 0 - 3): ");
                str = input.nextLine();
            } while (!str.matches("^[0-9]$"));
            int num = Integer.parseInt(str);
            switch (num) {
                case 0:
                    break;
                case 1:
                    staff = new Admin();
                    staff.insert();
                    list.add(staff);
                    break;
                case 2:
                    staff = new Marketing();
                    staff.insert();
                    list.add(staff);
                    break;
                case 3:
                    staff = new Manager();
                    staff.insert();
                    list.add(staff);
                    break;
                default:
                    System.out.println("Khong co chuc vu " + num);
            }
        } while (!str.equals("0"));
    }
    
    //xuat danh sach
    public void showList() {
        int i = 1;
        if (!list.isEmpty()) {
            for (Staff index : list) {
                System.out.print(i++ + " ");
                index.display();
            }
        }
        else {
            System.out.println("Danh sach rong. Hay nhap them");
        }
    }

    //tim kiem nhan vien theo ma
    public Staff find(String ID) {
        Staff temp = null;
        for (Staff index : list) {
            if(index.getID().equalsIgnoreCase(ID)){
                temp = index;
                break;
            }
        }
        return temp;
    }

    //xuat nhan vien tim duoc
    public void findStaff(String ID) {
        Staff found = find(ID);        
        if (found != null) {
            if(found instanceof Admin) {
                ((Admin)found).display();
            }else if(found instanceof Manager) {
                ((Manager)found).display();
            }else if(found instanceof Marketing) {
                ((Marketing)found).display();
            }
        }
        else {
            System.out.println("Khong tim thay nhan vien!");
        }
    }

    //xoa nhan vien tim duoc
    public void deleteStaff(String ID) {
        Staff deleted = find(ID);
        if (deleted != null) {
            System.out.println("Ban co chac muon xoa nhan vien nay?");
            if (input.nextLine().equalsIgnoreCase("y")) {
                if (deleted != null) {
                    list.remove(deleted);
                }
            }
        }
        else {
            System.out.println("Khong tim thay nhan vien nay");
        }
    }

    //cap nhat thong tin nhan vien theo ma tim duoc
    public void updateStaff(String ID) {
        Staff updated = find(ID);

        if (updated != null) {
            if(updated instanceof Admin) {
                ((Admin)updated).insert();
            }else if(updated instanceof Manager) {
                ((Manager)updated).insert();
            }else if(updated instanceof Marketing) {
                ((Marketing)updated).insert();
            }
            System.out.println("Nhan vien da duoc cap nhat!");
        }
        else {
            System.out.println("Khong tim thay nhan vien!");
        }
    }

    //tim nhan vien theo khoang luong
    public void findPay(double begin, double end) {
        int flag = 0;
        for (Staff index : list) {
            double pay = index.getPay();
            if(pay >= begin && pay <= end) {
                index.display();
                flag = 1;
                System.out.println();
            }
        }

        if (flag == 0) {
            System.out.println("Khong co nhan vien nao co luong trong khoang " + begin + " - " + end);
        }
    }

    //sap xep danh sach theo ten
    public void sortName() {
        Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName()));
    }

    //sap xep theo luong
    public void sortPay() {
        Collections.sort(list, (a, b) -> (int) (a.getThuNhap() - b.getThuNhap()));
    }

    //hien thi top 5 co luong cao nhat
    public void showTop5() {
        Collections.sort(list, (a, b) -> (int) (b.getThuNhap() - a.getThuNhap()));
        if(list.size() != 0) {
            if (list.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    System.out.print(i + 1);
                    list.get(i).display();
                }
            }
            else {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(i + 1);
                    list.get(i).display();
                }
            }
        }
        else {
            System.out.println("Danh sach rong");
        }
    }
}