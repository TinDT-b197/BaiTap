import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLi {
    private List<KhachHang> ListKhachHang;
    private List<HoaDon> ListHoaDon;
    private List<BangGiaDichVu> ListBangGiaDichVu;

    public void ThemKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng: ");
        String id = sc.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        String name = sc.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        String address = sc.nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        String phone = sc.nextLine();

        KhachHang khmoi = new KhachHang(id, name, address, phone);
        ListKhachHang.add(khmoi);
    }

    public void XoaKhachHang() {
        KhachHang kh = new KhachHang();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã khách muốn xóa: ");
        String id = sc.nextLine();
        if (id.equals(kh.getIdKH())) {
            ListKhachHang.remove(kh);
        }
    }

    public void SuaKhachHang() {
        KhachHang kh = new KhachHang();
        kh.SuaKhachHang(kh);
    }

    public void ShowKhachHang() {
        System.out.println("Thông tin khách hàng");
        System.out.println("-----------------------------------------------------");
        System.out.printf("| %-4s | %-20s |%-20s |%-10s |\n", "ID", "Tên Khách Hàng", "Địa chỉ", "SDT");
        for (KhachHang kh : ListKhachHang) {
            System.out.printf("|%-4s|%-20s|%-20s|%-10s|\n", kh.getIdKH(), kh.getTenKH(), kh.getDiachi(), kh.getSdt());
        }
    }
    public void ThemHoaDon(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id hóa đơn: ");
        String id = sc.nextLine();
        System.out.println("Nhập Ngày lập hóa đơn: ");
        String Ngay = sc.nextLine();
        System.out.println("Nhập số GB tiêu thụ: ");
        int GBTT = sc.nextInt();
        HoaDon newhoadon = new HoaDon(id,Ngay,GBTT);
        ListHoaDon.add(newhoadon);
    }
    public void ShowHoaDonChuaTT(){
        List<HoaDon> SortedHoaDon = ListHoaDon.stream()
                .sorted(Comparator.comparing(HoaDon::isTrangThaiThanhToan))
                .toList();
    }
    public void ShowBangGiaDichVu(){
        System.out.println("Bảng giá hiện tại");
        System.out.println("-----------------------------------------------------");
        System.out.printf("| %-20s |%-20s |%-10s |\n", "<51GB", "Từ 51GB đến 100GB", ">100GB");
        for (HoaDon hd : ListHoaDon) {
            System.out.printf("|%-4s|%-20s|%-20s|%-10s|\n",hd.getGiaTien());
        }
    }
}
