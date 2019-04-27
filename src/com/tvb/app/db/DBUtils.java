package com.tvb.app.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static List<Map<String, String>> resultSet2List(ResultSet rs) {

        ArrayList<Map<String, String>> list = null;
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            list = new ArrayList<>(50);
            while (rs.next()){
                HashMap<String, String> row = new HashMap<>(columns);
                for(int i=1; i<=columns; ++i){
                    row.put(md.getColumnName(i),rs.getString(i));
                }
                list.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // TODO maybe throw exception instead
        }

        return list;
    }

    public static Map<String, String> resultSetGet1(ResultSet rs) {
        if (rs == null) return null;
        HashMap<String, String> row = null;
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            if (rs.next()){
                row = new HashMap<>(columns);
                for(int i=1; i<=columns; ++i){
                    row.put(md.getColumnName(i),rs.getString(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
