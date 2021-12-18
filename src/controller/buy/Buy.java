package controller.buy;

import common.Product;
import common.ServerInfo;
import common.User;
import strings.Error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/buy")
public class Buy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("is_login") == "false" ||
                session.getAttribute("is_login") == null)
        {
            // 로그인이 안된 사용자
            resp.sendRedirect("/login");
            return;
        }
        final String referer = req.getHeader("referer");
        final String url = ServerInfo.URL + ":" + ServerInfo.PORT;
        User user = new User(session);
        if(referer.equals(url+"/basket"))
        {
            ArrayList<Product> buyList = (ArrayList<Product>)session.getAttribute("list");
            // 복수 구매
            if(buyList != null)
            {
               for(Product product : buyList) {
                   if(product != null) {
                       user.buyProduct(product.getId());
                   }
               }
            }
            else {
                req.setAttribute("error", Error.Buy.EMPTY_BASKET);
                req.getRequestDispatcher("buy.jsp").forward(req,resp);
            }
        }
        else if(referer.equals(url+"/search") || referer.equals(url+"/index"))
        {
            // 단일 구매
            int product_id = Integer.parseInt(req.getParameter("value"));
            try
            {
                user.buyProduct(product_id);
                req.setAttribute("good","true");
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
            }
        }

        req.getRequestDispatcher("buy.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("buy.jsp").forward(req,resp);
    }
}
