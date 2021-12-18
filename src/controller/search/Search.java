package controller.search;

import common.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        final String value = req.getParameter("value");
        ArrayList<Product> list = null;
        if(value == null)
        {
            try{
                list = product.getProductList();
                req.setAttribute("list", list);
            } catch(Exception e) {
                req.setAttribute("error", e.getMessage());
            }
            req.getRequestDispatcher("search.jsp").forward(req,resp);

        }
        else
        {
            try {
                list = product.getSearchProductList(value);
                req.setAttribute("list", list);
            } catch(Exception e) {
                req.setAttribute("error", e.getMessage());
            }
            req.getRequestDispatcher("search.jsp").forward(req,resp);
        }

    }

}
