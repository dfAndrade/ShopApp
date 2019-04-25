package com.tvb.app.db.dao;

import com.tvb.app.db.DBInteraction;

import java.util.HashMap;
import java.util.TreeMap;

public class UserDao  {

    /** This method is specific for USERS data */
    public TreeMap<String, HashMap<String,String>> getUsers(String namePattern) {
        TreeMap<String,HashMap<String,String>> users = new TreeMap<>();
        String selectUsers =
                "SELECT userID, firstName, lastName, address, phone FROM USERS " +
                        "WHERE lastName like '%" + namePattern + "%'";

        try {
            users = DBInteraction.query(selectUsers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}