package com.example.cuoiki;

public class Account {
    private String Name;
    private String Cccd;
    private String Year;
    private String phone;
    private String Pass;

    public Account() {}
    public Account(String name, String cccd, String year, String phone, String pass) {
        this.Name = name;
        this.Cccd = cccd;
        this.Year = year;
        this.phone = phone;
        this.Pass = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCccd() {
        return Cccd;
    }

    public void setCccd(String cccd) {
        Cccd = cccd;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
