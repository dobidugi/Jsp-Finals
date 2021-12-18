package controller.basket;

import common.Product;
import strings.Error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet("/basket")
public class Basket  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Integer> productIdList = null;
        Enumeration headerNames =  req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = (String)headerNames.nextElement();
            String value = req.getHeader(name);
            if(name.equals("cookie")) {
                productIdList = getBasketCookieValue(value);
                break;
            }
        }
        if(productIdList != null )
        {
            Product product = new Product();
            ArrayList<Product> list = new ArrayList<>();
            try {
                for(int id : productIdList ) {
                    list.add(product.getProductInfo(id));
                }
                System.out.println("Product List Size" + list.size());
                req.setAttribute("list", list);
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
                req.setAttribute("error", e.getMessage());
            }

            for(Product p : list) {
                if(p!= null)
                    System.out.println(p.getName());
            }
        }
        else
        {
            req.setAttribute("error", Error.Product.EMPTY_BASKET);
        }


        req.getRequestDispatcher("basket.jsp").forward(req, resp);
    }

    public ArrayList<Integer> getBasketCookieValue(String value) {
        ArrayList<Integer> list = new ArrayList<>();
        String basketValue = null;
        String[] cookies= value.split(";");

        for(String cookie : cookies)
        {
            if(cookie.substring(0,7).equals("basket=")) {
                String[] tmp = cookie.split("=");
                basketValue = tmp[1];
                break;
            }
        }

        String[] productNums = basketValue.split(",");
        for(String num : productNums) {
            list.add(Integer.parseInt(num));
        }
        return list;

    }
}
