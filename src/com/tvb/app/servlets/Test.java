package com.tvb.app.servlets;

import com.tvb.app.db.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test extends HttpServlet {
    public static String test() {
        return "TEstseinfoan";
    }

    private int state = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        ProductDao pd = new ProductDao();
        req.setAttribute("test", pd.getAll());

        req.getRequestDispatcher("header.jsp").include(req, res);

        req.getRequestDispatcher("products/listProducts.jsp").include(req, res);

        req.getRequestDispatcher("footer.jsp").include(req, res);
    }
}
