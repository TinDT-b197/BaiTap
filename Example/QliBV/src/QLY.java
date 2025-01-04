import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class QLY {
    private ArrayList<Bnhan> DanhSachBenhNhan = new ArrayList<>();
    private ArrayList<Phong> DanhSachPhong = new ArrayList<>();
    private ArrayList<Khoa> DanhSachKhoa = new ArrayList<>();

    public void ThemKhoa(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ID khoa: ");
        int ID_Khoa = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten khoa: ");
        String tenkhoa = sc.nextLine();
        Khoa khoa1 = new Khoa(ID_Khoa, tenkhoa);
        DanhSachKhoa.add(khoa1);
    }

    public void ThemBacSi(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ID Bac Si: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten Bac Si: ");
        String ten = sc.nextLine();
        System.out.println("Nhap Khoa: ");
        String khoabs = sc.nextLine();
        System.out.println("Nhap tuoi bac si: ");
        int tuoi = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap dia chi bac si: ");
        String diaChi = sc.nextLine();
         bacsi = new BacSi(ten, tuoi,diaChi,id,khoabs);
        DanhSachKhoa.add(bacsi);
    }
    public void ThemPhong(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID Phong: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten Phong: ");
        String tenphong = sc.nextLine();
        System.out.println("Nhap so luong giuong: ");
        int soGiuong = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap so luong benh nhan: ");
        int soLuongBenhNhan = sc.nextInt();
        sc.nextLine();
        Phong phong = new Phong(id, tenphong,soGiuong,soLuongBenhNhan);
        DanhSachPhong.add(phong);
    }
    public void ThemBenhNhan() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID benh nhan: ");
        String ID = sc.nextLine();
        System.out.println("Nhap ten Benh nhan: ");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi benh nhan: ");
        int tuoi = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap dia chi benh nhan: ");
        String diaChi = sc.nextLine();
        System.out.println("Nhap ID Phong cua benh nhan: ");
        int id_phong = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap benh cua benh nhan: ");
        int benh = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ID Bac Si Dam Nhiem: ");
        int idbs = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ngay nhap vien: ");
        String ngaynhapvien = sc.nextLine();
        Bnhan benhnhan = new Bnhan(name,tuoi,diaChi,ID,benh,id_phong,idbs,ngaynhapvien);
        DanhSachBenhNhan.add(benhnhan);

    }
    public boolean XuatVien(String id){

        for(Bnhan bnhan : DanhSachBenhNhan){
            if(bnhan.getIDBN().equals(id)){
                bnhan.isDaXuatVien(true);
                System.out.println("Benh Nhan "+ bnhan.getName()+ " Da Xuat vien");
                return true;
            }
        }
        System.out.println("Khong tim thay benh nhan hoac benh nhan da xuat vien !");
        return false;
    }
    public void hienthidanhsach(){
        if(DanhSachBenhNhan.isEmpty()){
            System.out.println("Khong co benh nhan nao! ");
            return;
        }
        System.out.println("Danh sach benh nhan ");
        for(Bnhan bnhan : DanhSachBenhNhan){
            System.out.println(bnhan.getName()+" "+bnhan.getIDBN());
        }
    }
}