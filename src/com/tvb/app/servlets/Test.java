package com.tvb.app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Test extends HttpServlet {
    public static String test() {
        return "TEstseinfoan";
    }

    private int state = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter writer = res.getWriter();
        writer.println("WHY ME");

        List<String> l = new ArrayList<>();
        l.add("t1");
        l.add("t2");
        l.add("t3");
        l.add("t4");



        state++;
        System.out.println("State: " + state);

        req.setAttribute("test", l);
        req.getRequestDispatcher("index.jsp").include(req, res);
    }
}
