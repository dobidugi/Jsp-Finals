package controller.login;

import common.User;
import common.UserValidator;
import javafx.util.Pair;
import strings.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher failPage = req.getRequestDispatcher("login.jsp");
        User user = new User(req);
        UserValidator uv = new UserValidator(user);

        if(!uv.isValidLoginUser()) {
            req.setAttribute("error", Error.Login.EMPTY_FORM);
            failPage.forward(req, resp);
            return;
        }

        try {
            HashMap<String, String> res = user.auth();
            HttpSession session = req.getSession(true);
            session.setAttribute("is_login","true");
            session.setAttribute("id", res.get("id"));
            session.setAttribute("userid", res.get("userid"));
            resp.sendRedirect("index");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
            failPage.forward(req, resp);
        }

    }
}
