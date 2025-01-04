import java.util.ArrayList;

public class Phong implements QuanLiBV {
    private int IDPhong;
    private String TenPhong;
    private int SoLuongGiuong;
    private int SoLuongBenhNhan;
    private ArrayList<Bnhan> danhSachBenhNhantrongPhong;

    public Phong(int IDPhong, String TenPhong, int SoLuongPhong, int SoLuongBenhNhan) {
        this.IDPhong = IDPhong;
        this.TenPhong = TenPhong;
        this.SoLuongGiuong = SoLuongGiuong;
        this.SoLuongBenhNhan = SoLuongBenhNhan;
        this.danhSachBenhNhantrongPhong = new ArrayList<>();
    }
    public int getIDPhong() {
        return IDPhong;
    }
    public void setIDPhong(int IDPhong) {
        this.IDPhong = IDPhong;
    }
    public String getTenPhong() {
        return TenPhong;
    }
    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }
    public int getSoLuongGiuong() {
        return SoLuongGiuong;
    }
    public void setSoLuongGiuong(int SoLuongGiuong) {
        this.SoLuongGiuong = SoLuongGiuong;
    }
    public int getSoLuongBenhNhan() {
        return SoLuongBenhNhan;
    }

    @Override
    public String toString() {
        return "ID Phong: "+ getIDPhong()+" Ten Phong: "+getTenPhong();
    }
    public ArrayList<Bnhan> DanhSachBenhNhantrongPhong() {
        return danhSachBenhNhantrongPhong;
    }
    public void ThemBenhNhan(Bnhan benhnhan){
        if(danhSachBenhNhantrongPhong.size() < SoLuongGiuong){
            danhSachBenhNhantrongPhong.add(benhnhan);
        }
        else{
            System.out.println("So giuong con lai khong du.");
        }
    }
}
