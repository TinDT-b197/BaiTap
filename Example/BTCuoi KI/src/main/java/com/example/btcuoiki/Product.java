package com.example.btcuoiki;

public class Product {
    private String productID;
    private String productName;
    private String Price;
    private int Quantity;

    public Product(String productID, String productName, String Price, int Quantity) {
        this.productID = productID;
        this.productName = productName;
        this.Price = Price;
        this.Quantity = Quantity;
    }
    public Product() {}

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    public boolean subtractQuantity(int amount) {
        if (Quantity >= amount) {
            Quantity -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void addQuantity(int amount) {
        Quantity += amount;
    }
    public void reduceQuantity(int amount) {
        Quantity += amount;
    }
}

