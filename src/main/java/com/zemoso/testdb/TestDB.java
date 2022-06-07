package com.zemoso.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
    //Setup connection variables
    public static void main(String[] args) throws SQLException {

        String user = "nivesh";
        String pass = "Nanizemoso@3338";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.cj.jdbc.Driver";

        //get connection to database

        try {
            System.out.println("Connecting to database");
            Class.forName(driver);

            Connection myconn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection Successful");
            myconn.close();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    //
}
