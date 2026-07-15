package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/food_delivary";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lasya@5859#2004";

    private static Connection con = null;

    public static Connection getConnection() {

        try {

            if (con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                System.out.println("Database Connected Successfully...");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void closeConnection() {

        try {

            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Connection Closed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Connection c = getConnection();

        if (c != null) {
            System.out.println("Connection Success");
        } else {
            System.out.println("Connection Failed");
        }

    }
}