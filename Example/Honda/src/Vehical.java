public class Vehical implements Printable{
    private String name;
    private String ID_vehical;
    private String Tax_code;
    private double price;
    private String Date_Of_Entry;
    private boolean Status;

    public Vehical(String name, String ID_vehical, String Tax_code, double price, String Date_Of_Entry) {
        this.name = name;
        this.ID_vehical = ID_vehical;
        this.Tax_code = Tax_code;
        this.price = price;
        this.Date_Of_Entry = Date_Of_Entry;
        this.Status = true;
    }
    public String getName() {
        return name;
    }
    public String getID_vehical() {
        return ID_vehical;
    }
    public String getTax_code() {
        return Tax_code;
    }
    public double getPrice() {
        return price;
    }
    public String getDate_Of_Entry() {
        return Date_Of_Entry;
    }
    public Boolean IsStatus() {
        return Status;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID_vehical(String ID_vehical) {
        this.ID_vehical = ID_vehical;
    }
    public void setTax_code(String Tax_code) {
        this.Tax_code = Tax_code;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDate_Of_Entry(String Date_Of_Entry) {
        this.Date_Of_Entry = Date_Of_Entry;
    }
    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    @Override
    public String print() {
        return "Tên xe: "+ name + " Giá tiền: "+ price;
    }
}