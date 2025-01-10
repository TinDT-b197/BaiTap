package com.example.btcuoiki.Database;

import com.example.btcuoiki.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDB implements DAO<Product> {


    public static ProductDB GetInstance() {
        return new ProductDB();
    }

    @Override
    public int Add(Product product) {
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO product(productID, productName, Price, Quantity)"+
                    "VALUES('"+product.getProductID()+"','"+product.getProductName()+"','"+product.getPrice()+"',"+product.getQuantity()+")";
            System.out.println(sql);
            int result = st.executeUpdate(sql);

            ConnectDB.CloseConnetion(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Remove(Product product) {
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "DELETE from product"+
                    " WHERE productID='"+product.getProductID()+"\'";
            ;
            System.out.println(sql);
            int result = st.executeUpdate(sql);

            ConnectDB.CloseConnetion(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Update(Product product) {
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "UPDATE product"+
                    " SET "+
                    " productName='"+product.getProductName()+"'"+
                    ",Price='"+product.getPrice()+"'"+
                    ",Quantity="+product.getQuantity()+
                    " WHERE productID='"+product.getProductID()+"\'";
            System.out.println(sql);
            int result = st.executeUpdate(sql);

            ConnectDB.CloseConnetion(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList selectAll() {
        ArrayList<Product> result = new ArrayList<>();
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM product";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("productID"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getString("Price"));
                product.setQuantity(rs.getInt("Quantity"));
                result.add(product);
            }

            ConnectDB.CloseConnetion(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
