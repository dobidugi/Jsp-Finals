package controller.myinfo;

import common.OrderItem;
import common.User;
import exception.AuthException;
import strings.Error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/myinfo")
public class Myinfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(
                session.getAttribute("is_login") == "fasle" ||
                session.getAttribute("is_login") == null
        ) {
            resp.sendRedirect("/login");
            return;
        }

        User user = new User(req.getSession());
        try {
            user.getUserInfo();
            ArrayList<OrderItem> list = user.getOrderList();
            req.setAttribute("user",user);
            req.setAttribute("list", list);
        } catch(Exception e){
            throw new AuthException(Error.DB_ERROR);
        }
        req.getRequestDispatcher("myinfo.jsp").forward(req, resp);
    }
}
