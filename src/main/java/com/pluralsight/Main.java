package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String connectionString = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "Yearup$909";

        try (Connection conn = DriverManager.getConnection(connectionString, username, password)) {

            System.out.println("Connected!");

            String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products";            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                double price = rs.getDouble("UnitPrice");
                int stock = rs.getInt("UnitsInStock");
                System.out.printf(" ProductID: %s%n ProductName: %s%n UnitPrice: %s%n UnitInStock: %s%n" +
                                "%n--------------------------------%n", id, name, price, stock);
            }
        } catch (SQLException e) {
            System.out.println("An SQLException Occurred: " + e.getMessage());
        }
    }
}