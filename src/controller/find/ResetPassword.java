package controller.find;

import common.User;
import common.UserValidator;
import strings.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/resetpw")
public class ResetPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.getRequestDispatcher("error.jsp").forward(req, resp); // 직접 페이지에 접근을 막음
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher failPage = req.getRequestDispatcher("resetpw.jsp");
        RequestDispatcher successPage = req.getRequestDispatcher("login.jsp");
        User user = new User(req);
        UserValidator uv = new UserValidator(user);
        if
        (
                !session.getAttribute("userid").equals(req.getParameter("id"))  ||
                        !session.getAttribute("name").equals(req.getParameter("name"))   ||
                        !session.getAttribute("phone").equals(req.getParameter("phone"))
        ) { // 세션에 들어있는값하고 페이지에서 보낸값이 다르면 악의적으로 변경해서 바꾸려는 시도로 볼수있음
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return ;
        } else {
            if(!uv.isValidResetPassword()) {
                req.setAttribute("error", Error.FindUserInfo.EMPTY_FORM);
                failPage.forward(req,resp);
                return;
            }
            if(!user.getPassword().equals(user.getPassword2())) {
                req.setAttribute("error",Error.FindUserInfo.NEW_PASSWORD_NOT_MATCH);
                failPage.forward(req,resp);
                return;
            }

            try {
                boolean res = user.resetPassword();
                session.invalidate();
                resp.sendRedirect("login");
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                failPage.forward(req,resp);
            }
        }
    }
}
