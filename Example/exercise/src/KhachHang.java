import java.util.List;
import java.util.Scanner;

public class KhachHang {
    private String IdKH;
    private String TenKH;
    private String Diachi;
    private String Sdt;

    public KhachHang() {}
    public KhachHang(String idKH, String TenKH, String Diachi, String Sdt) {
        this.IdKH = idKH;
        this.TenKH = TenKH;
        this.Diachi = Diachi;
        this.Sdt = Sdt;

    }

    public String getIdKH() {
        return IdKH;
    }

    public void setIdKH(String idKH) {
        IdKH = idKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }


    List<KhachHang> ListKhachHang;
    public void ThemKhachHang(KhachHang newkh) {
        ListKhachHang.add(newkh);
    }
    public void SuaKhachHang(KhachHang kh){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id khách hàng cần sửa thông tin: ");
        String id = sc.nextLine();
        if(id.equals(getIdKH())){
            while(true) {
                System.out.println("Chọn thông tin khách hàng cần sửa: ");
                System.out.println("1. Tên khách hàng");
                System.out.println("2. Địa chỉ");
                System.out.println("3. Số điện thoại");
                System.out.println("4. Thoát");
                System.out.println("Nhập lựa chọn của bạn: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        String newname = sc.nextLine();
                        setTenKH(newname);
                        System.out.println("Tên khách hàng đã được thay đổi ");
                        break;
                    case 2:
                        String newDiachi = sc.nextLine();
                        setDiachi(newDiachi);
                        System.out.println("Địa chỉ khách hàng đã được thay đổi");
                        break;
                    case 3:
                        String newSdt = sc.nextLine();
                        setSdt(newSdt);
                        System.out.println("Số điện thoại khách hàng đã được thay đổi");
                        break;
                    case 4:
                        System.out.println("Thoát!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }
        else {
            System.out.println("Khách hàng không tồn tại!");
        }
    }
    public void XoaKhachHang(KhachHang kh){
        ListKhachHang.remove(kh);
    }
}
