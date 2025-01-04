package com.example.btcuoiki;

public class Order {
    private String Id;
    private String NameCustomer;
    private String Phone;
    private String ProductIdOr;
    private String ProductNameOrder;
    private int QuantityOrder;

    public Order() {}

    public String getProductIdOr() {
        return ProductIdOr;
    }

    public void setProductIdOr(String productIdOr) {
        ProductIdOr = productIdOr;
    }

    public String getProductNameOrder() {
        return ProductNameOrder;
    }

    public void setProductNameOrder(String productNameOrder) {
        ProductNameOrder = productNameOrder;
    }

    public Order(String Id, String NameCustomer, String Phone,String ProductIdOrder, String ProductNameOrder, int QuantityOrder) {
        this.Id = Id;
        this.NameCustomer = NameCustomer;
        this.Phone = Phone;
        this.ProductIdOr = ProductIdOrder;
        this.ProductNameOrder = ProductNameOrder;
        this.QuantityOrder = QuantityOrder;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNameCustomer() {
        return NameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        NameCustomer = nameCustomer;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


    public int getQuantityOrder() {
        return QuantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        QuantityOrder = quantityOrder;
    }

}
