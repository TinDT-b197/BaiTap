import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer extends Person implements Printable{
    private int point;
    private Date dateOfPurchase;
    private String nameOfVehicle;
    private Vehical vehical_Buy;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Customer(String name, String phone, String cccd, String dateOfPurchase, String nameOfVehicle) throws ParseException {
        super(name,phone,cccd);
        this.point = 0 ;
        this.dateOfPurchase = dateFormat.parse(dateOfPurchase);
        this.nameOfVehicle = nameOfVehicle;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }
    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
    public String getNameOfVehicle() {
        return nameOfVehicle;
    }
    public void setNameOfVehicle(String nameOfVehicle) {
        this.nameOfVehicle = nameOfVehicle;
    }
    public void CongDiem(int diem){
        this.point += diem;
    }
    public double TinhTien(){
        double TienGiam = (point * 10)*vehical_Buy.getPrice()/100;
        return vehical_Buy.getPrice() - TienGiam;
    }

    @Override
    public String print() {
        return "Ten Khach hang: "+ name + " So dien thoai: "+phone+" ten xe: "+ nameOfVehicle + " Ngay mua: " + dateOfPurchase;
    }
}
