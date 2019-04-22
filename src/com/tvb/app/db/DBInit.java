package com.tvb.app.db;

import java.sql.*;

public class DBInit {
    public static void main(String... args) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();


            int res = stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS sa");

            System.out.println("Creating Schema: " + res);

            res = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS sa.prods (id integer PRIMARY KEY," +
                    "label varchar(40) NOT NULL)");

            System.out.println("Creating product table: " + res);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
