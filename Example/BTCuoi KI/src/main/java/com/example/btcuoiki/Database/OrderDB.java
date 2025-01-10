package com.example.btcuoiki.Database;

import com.example.btcuoiki.Order;


import java.sql.*;
import java.util.ArrayList;

public class OrderDB implements DAO<Order> {
    public static OrderDB getInstance() {
        return new OrderDB();
    }

    @Override
    public int Add(Order order) {
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO DonHang (Id, NameCustomer, Phone, ProductIdOr, ProductNameOrder, QuantityOrder)"+
                    " VALUES('"+order.getId()+"','"+order.getNameCustomer()+"','"+order.getPhone()+"','"+order.getProductIdOr()+"','"+order.getProductNameOrder()+"',"+order.getQuantityOrder()+")";
            System.out.println(sql);
            int result = st.executeUpdate(sql);

            ConnectDB.CloseConnetion(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Remove(Order order) {
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "DELETE from DonHang"+
                    " WHERE Id='"+order.getId()+"\'";
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
    public int Update(Order order) {
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "UPDATE DonHang"+
                    " SET "+
                    " NameCustomer='"+order.getNameCustomer()+"'"+
                    ",Phone='"+ order.getPhone()+"'"+
                    ",ProductIdOr='"+order.getProductIdOr()+"'"+
                    ",ProductNameOrder='"+order.getProductNameOrder()+"'"+
                    ", QuantityOrder="+order.getQuantityOrder()+
                    " WHERE Id='"+order.getId()+"\'";
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
    public ArrayList<Order> selectAll() {
        ArrayList<Order> result = new ArrayList<>();
        Connection con = ConnectDB.getConnetion();

        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM DonHang";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getString("Id"));
                order.setNameCustomer(rs.getString("NameCustomer"));
                order.setPhone(rs.getString("Phone"));
                order.setProductIdOr(rs.getString("ProductIdOr"));
                order.setProductNameOrder(rs.getString("ProductNameOrder"));
                order.setQuantityOrder(rs.getInt("QuantityOrder"));
                result.add(order);
            }

            ConnectDB.CloseConnetion(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
