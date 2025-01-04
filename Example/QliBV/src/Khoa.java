import java.lang.reflect.Array;
import java.util.ArrayList;

public class Khoa {
    private int ID_Khoa;
    private String TenKhoa;
    private ArrayList<BacSi> danhSachBacSi;

    public Khoa(int ID_Khoa, String TenKhoa) {
        this.ID_Khoa = ID_Khoa;
        this.TenKhoa = TenKhoa;
        this.danhSachBacSi = new ArrayList<>();
    }

    public int getID_Khoa() {
        return ID_Khoa;
    }
    public void setID_Khoa(int ID_Khoa) {
        this.ID_Khoa = ID_Khoa;
    }
    public String getTenKhoa() {
        return TenKhoa;
    }
    public void setTenKhoa(String TenKhoa) {
        this.TenKhoa = TenKhoa;
    }
    public ArrayList<BacSi> getDanhSachBacSi() {
        return danhSachBacSi;
    }
    public void DoiTenKhoa(String tenKhoaMoi) {
        this.TenKhoa = tenKhoaMoi;
    }
    public void ThemBacSi(BacSi bacSi) {
        this.danhSachBacSi.add(bacSi);
    }
    public void XoaBacSi(BacSi bacSi) {
        this.danhSachBacSi.remove(bacSi);
    }
}
