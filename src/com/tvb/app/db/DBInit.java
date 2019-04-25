package com.tvb.app.db;

public class DBInit {
    public static void main(String... args) {

        int res = DBInteraction.update("CREATE TABLE IF NOT EXISTS sa.prods (id integer PRIMARY KEY," +
                "label varchar(40) NOT NULL)");

        System.out.println("Creating product table: " + res);

    }
}
