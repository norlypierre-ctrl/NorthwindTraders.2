package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String connectionString = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "Yearup$909";

        try (Connection conn = DriverManager.getConnection(connectionString, username, password)) {
            Class.forName( "com.mysql.cj.jdbc. Driver");

            System.out.println("Connected!");

            String query = "SELECT ProductName FROM Products";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("ProductName");
                System.out.println(name);
            }
        } catch (SQLException e) {
            System.out.println("An SQLException Occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}