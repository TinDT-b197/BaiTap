import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Bnhan extends Person implements QuanLiBN{
    private String ID_bn;
    private int ID_Benh;
    private int ID_Phong;
    private Date NgayNhapVien;
    private Date NgayXuatVien;
    private int ID_BSDamNhiem;
    private boolean daXuatVien;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Bnhan(String name, int year, String address,String ID_bn, int ID_Benh, int ID_Phong,int ID_BSDamNhiem, String NgayNhapVien) throws ParseException {
        super(name, year, address);
        this.ID_bn = ID_bn;
        this.ID_Benh = ID_Benh;
        this.ID_Phong = ID_Phong;
        this.ID_BSDamNhiem = ID_BSDamNhiem;
        this.daXuatVien = false;
        this.NgayNhapVien = dateFormat.parse(NgayNhapVien);
        this.NgayNhapVien = null;
    }
    public String getIDBN() {
        return ID_bn;
    }
    public void setID_bn(String ID_bn) {
        this.ID_bn = ID_bn;
    }
    public int getID_Benh() {
        return ID_Benh;
    }
    public void setID_Benh(int ID_Benh) {
        this.ID_Benh = ID_Benh;
    }
    public int getID_Phong() {
        return ID_Phong;
    }
    public void setID_Phong(int ID_Phong) {
        this.ID_Phong = ID_Phong;
    }
    public Date getNgayNhapVien() {
        return NgayNhapVien;
    }
    public void setNgayNhapVien(Date NgayNhapVien) {
        this.NgayNhapVien = NgayNhapVien;
    }
    public void NhapVien(String NgayNhapVien) throws ParseException {
        this.NgayNhapVien = dateFormat.parse(NgayNhapVien);
        this.NgayXuatVien = null;
        this.daXuatVien = false;
    }
    public Date getNgayXuatVien() {
        return NgayXuatVien;
    }
    public void setNgayXuatVien(Date ngayXuatVien) {
        this.NgayXuatVien = ngayXuatVien;
        this.daXuatVien = true;
    }
    public boolean isDaXuatVien(boolean b) {
        return daXuatVien;
    }
    public void XuatVien(String NgayXuatVien) throws ParseException {
        Date NgayXuat = dateFormat.parse(NgayXuatVien);
        this.NgayXuatVien = dateFormat.parse(NgayXuatVien);
        if (NgayXuat.after(this.NgayNhapVien)) {
            this.NgayXuatVien = NgayXuat;
            this.daXuatVien = true;
        } else {
            System.out.println("Ngày xuất viện phải sau ngày nhập viện.");
        }
    }
    public int getID_BSDamNhiem() {
        return ID_BSDamNhiem;
    }
    public void setID_BS(int ID_BSDamNhiem) {
        this.ID_BSDamNhiem = ID_BSDamNhiem;
    }

    @Override
    public String toString() {
        return super.toString()+", ID Benh Nhan: "+ ID_bn;
    }
    public void thayDoiBacSiDamNhiem(int ID_BSDamNhiem) {
        this.ID_BSDamNhiem = ID_BSDamNhiem;

    }
    public void thayDoiPhong(int ID_Phong) {
        this.ID_Phong = ID_Phong;
    }
}

