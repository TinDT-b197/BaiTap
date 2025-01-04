package com.example.btcuoiki.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static String DB_URL = "jdbc:mysql://localhost:3306/shopmanager";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    public static Connection getConnetion()  {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static void CloseConnetion(Connection con) {
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void printInfo(Connection con) {
        try {
            if (con != null) {
                System.out.println(con.getMetaData().toString());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

