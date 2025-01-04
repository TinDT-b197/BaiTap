import java.lang.reflect.Array;
import java.util.ArrayList;

public class BacSi extends Person{
    private int ID_BS;
    private String KhoaDamNhiem;
    private ArrayList<Bnhan> danhSachBenhNhan;

    public BacSi(String name,int year,String address,int ID_BS,String KhoaDamNhiem){
        super(name,year,address);
        this.ID_BS=ID_BS;
        this.KhoaDamNhiem=KhoaDamNhiem;
        this.danhSachBenhNhan=new ArrayList<>();
    }
    public int getID_BS() {
        return ID_BS;
    }
    public void setID_BS(int ID_BS) {
        this.ID_BS = ID_BS;
    }
    public String getKhoaDamNhiem() {
        return KhoaDamNhiem;
    }
    public void setKhoaDamNhiem(String KhoaDamNhiem) {
        this.KhoaDamNhiem = KhoaDamNhiem;
    }
    public ArrayList<Bnhan> getDanhSachBenhNhan() {
        return danhSachBenhNhan;
    }
    public void themBenhNhan(Bnhan benhnhan){
        danhSachBenhNhan.add(benhnhan);
    }
    public void doiKhoaDamNhiem(String ChuyenKhoaMoi){
        this.KhoaDamNhiem=ChuyenKhoaMoi;
    }


}
