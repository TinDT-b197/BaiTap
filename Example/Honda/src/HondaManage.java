import java.text.ParseException;
import java.util.*;

public class HondaManage {
    private ArrayList<Customer>customersList = new ArrayList<>();
    private ArrayList<Vehical>vehicalsList = new ArrayList<>();

    public void ThemKhachHang() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten khach hang: ");
        String name = sc.nextLine();
        System.out.println("Nhap SDT khach hang: ");
        String phone = sc.nextLine();
        System.out.println("Nhap cccd khach hang: ");
        String cccd = sc.nextLine();
        System.out.println("Nhap ten xe: ");
        String tenxe = sc.nextLine();
        System.out.println("Nhap ngay mua: ");
        String ngay = sc.nextLine();
        Customer customer = new Customer(name,phone,cccd,ngay, tenxe);
        customersList.add(customer);
    }
    public void ThemXe(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten xe: ");
        String name = sc.nextLine();
        System.out.println("Nhap ID xe: ");
        String id = sc.nextLine();
        System.out.println("Nhap ngay nhap: ");
        String ngay = sc.nextLine();
        System.out.println("Nhap tien thue: ");
        String tax = sc.nextLine();
        System.out.println("Nhap gia tien : ");
        double gia = sc.nextDouble();
        Vehical vehical = new Vehical(name,id,tax,gia,ngay);
        vehicalsList.add(vehical);
    }
    public void XepDSNguoiMuaTheoNgay() throws ParseException {
        Collections.sort(customersList, new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2) {
                return c1.getDateOfPurchase().compareTo(c2.getDateOfPurchase());
            }
        });
        System.out.println("Đã sắp xếp danh sách người mua theo yêu cầu!");
    }
    public void InDS(){
        for (Customer customer : customersList) {
            System.out.println("Danh sách người mua");
            System.out.println(customer.print());
        }
    }
    public void KiemTraKho(){
        for (Vehical vehical : vehicalsList) {
            if(vehical.IsStatus()){
                System.out.println(vehical.print());
            }
        }
    }

    public void ThemXe(Vehical vehical) {
        vehicalsList.add(vehical);
    }
}
