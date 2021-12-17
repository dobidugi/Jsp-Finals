package controller.index;

import common.Product;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        ArrayList<Product> list = null;
        try{
            list = product.getProductList();
            req.setAttribute("list", list);
            System.out.println("good");
        } catch(Exception e) {
            req.setAttribute("error", e.getMessage());
            System.out.println(e.getMessage());
        }
        finally {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
