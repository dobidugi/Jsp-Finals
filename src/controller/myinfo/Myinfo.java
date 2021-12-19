package controller.myinfo;

import common.User;
import exception.AuthException;
import org.omg.CORBA.UserException;
import strings.Error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
            req.setAttribute("user",user);
        } catch(Exception e){
            throw new AuthException(Error.DB_ERROR);
        }
        req.getRequestDispatcher("myinfo.jsp").forward(req, resp);
    }
}
