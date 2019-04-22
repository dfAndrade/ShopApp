package com.tvb.app.db;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class DBTest {

    String foo = "Not Connected";
    int bar = -1;

    public void init() {
        try {
            Context ctx = new InitialContext();

            // /jdbc/postgres is the name of the resource above
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/postgres");

            if (ds != null) {
                Connection conn = ds.getConnection();

                if (conn != null) {
                    foo = "Got Connection " + conn.toString();
                    Statement stmt = conn.createStatement();
                    ResultSet rst = stmt.executeQuery("select id, foo, bar from testdata");

                    if (rst.next()) {
                        foo = rst.getString(2);
                        bar = rst.getInt(3);
                    }
                    conn.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFoo() {
        return foo;
    }

    public int getBar() {
        return bar;
    }
}