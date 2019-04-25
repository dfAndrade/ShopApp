package com.tvb.app.db;

import com.tvb.app.AppUtils;

import java.sql.*;
import java.util.HashMap;
import java.util.TreeMap;

/** This class contains a generic code for data manipulation */
public class DBInteraction {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb/as";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_USER = "postgres";
    private static final String DB_PWD = "postgres";

    /** This is a generic method for the query operation */
    public static TreeMap<String, HashMap<String,String>> query(String selectQuery) {

        Connection conn = connect();

        if (conn == null) return null;

        TreeMap<String,HashMap<String,String>> selectResult = new TreeMap<>();
        String[] keys = selectQuery
                .replace(" ","")
                .replace("SELECT", "")
                .split("FROM")[0]
                .split(",");

        try {
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HashMap<String,String> eachResult = new HashMap<>();
                for (int i=1; i<keys.length; i++) {
                    eachResult.put(keys[i],rs.getString(i+1));
                }
                selectResult.put(rs.getString(1),eachResult);
            }

        } catch(SQLException sqlExc) {
            System.out.println(sqlExc.getMessage());
        } finally {
            try { conn.close(); }
            catch (SQLException sqlExc) {
                System.out.println(sqlExc.getMessage());
            }
        }

        return selectResult;
    }


    public static ResultSet select(String[] keys, String from, String where) {
        Connection conn = connect();

        if (conn == null || from == null || from.isEmpty()) return null;

        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT"
                    + String.join(", ", keys)
                    + "FROM" + from
                    + (where != null ? "WHERE" + where : null));
            return stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int update(String updateQuery) {
        Connection conn = connect();

        if (conn == null) return -1;

        try {
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            return stmt.executeUpdate();
        } catch(SQLException sqlExc) {
            System.out.println(sqlExc.getMessage());
            return -1;
        } finally {
            try { conn.close(); }
            catch (SQLException sqlExc) {
                System.out.println(sqlExc.getMessage());
            }
        }
    }

    public static boolean insert(String tableName, String[] params) {
        Connection conn = connect();

        if (conn == null) return false;

        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + tableName + " VALUES (NULL, " + AppUtils.repeat("?", params.length, ", ") + ")");
            for (int i = 0; i < params.length; i++) {
                stmt.setString(i, params[i]);
            }

            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    private static Connection connect() {
        try {
            Class.forName(DBInteraction.DB_DRIVER);
            return DriverManager.getConnection(DBInteraction.DB_URL, DBInteraction.DB_USER, DBInteraction.DB_PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}