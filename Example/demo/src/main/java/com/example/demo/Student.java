package com.example.demo;

public class Student {
    private String Name;
    private String Year;
    private String Gender;
    private String Grade;

    public Student() {}
    public String getName() {
        return Name;
    }
    public String getYear() {
        return Year;
    }
    public String getGender() {
        return Gender;
    }
    public String getGrade() {
        return Grade;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setYear(String Year) {
        this.Year = Year;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    public void setGrade(String Grade) {
        this.Grade = Grade;
    }
}
