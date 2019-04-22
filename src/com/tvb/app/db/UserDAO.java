package com.tvb.app.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.TreeMap;

public class UserDAO {
    private DBInteraction db = new DBInteraction();

    /** This method is specific for USERS data */
    public TreeMap<String, HashMap<String,String>> getUsers(String namePattern) {
        TreeMap<String,HashMap<String,String>> users = new TreeMap<>();
        String selectUsers =
                "SELECT userID, firstName, lastName, address, phone FROM USERS " +
                        "WHERE lastName like '%" + namePattern + "%'";

        try {
            users = db.select(selectUsers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return users;
    } // getUsers()

} // class MyDB