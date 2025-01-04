public abstract class Person {
    protected String name;
    protected String phone;
    protected String cccd;

    public Person(String name, String phone, String cccd) {
        this.name = name;
        this.phone = phone;
        this.cccd = cccd;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getCccd() {
        return cccd;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

}
