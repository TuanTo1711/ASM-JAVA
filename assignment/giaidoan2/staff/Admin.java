package assignment.giaidoan2.staff;

public class Admin extends Staff{
    public Admin() {
    }

    public Admin(String ID, String name, double pay) {
        super("Hanh Chinh", ID, name, pay);
    }

    public void insert() {
        super.insert();
        setType("Hanh Chinh");
    }
}
