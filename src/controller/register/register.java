package controller.register;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import common.User;
import common.UserValidator;
import javafx.util.Pair;
import strings.Error;

@WebServlet("/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher failPage = req.getRequestDispatcher("register.jsp");
        RequestDispatcher successPage = req.getRequestDispatcher("login.jsp");
        req.setCharacterEncoding("utf-8");
        User user = new User(req);
        UserValidator uv =new UserValidator(user);

        if(uv.isValidRegisterUser()) { // 폼정보를 모두 입력하였슴.
            String pw1 = user.getPassword();
            String pw2 = user.getPassword2();
            if(
                    !passwordCheck(pw1, pw2) && !pw1.equals(pw2)
            ) {
                req.setAttribute("error",Error.Regsiter.PASSWORD_NOT_MATCH);
                failPage.forward(req,resp);
                return;
            }

            Pair<Boolean, String> res = user.register();

            if(res.getKey()) { // 성공
                successPage.forward(req, resp);
                return;
            } else {
                req.setAttribute("error",res.getValue());
                failPage.forward(req,resp);
                return;
            }

        } else {
            req.setAttribute("error", Error.Regsiter.EMPTY_FORM);
            failPage.forward(req,resp);
            return;
        }

    }

    private boolean passwordCheck(String p1, String p2) {
        System.out.println(p1 + "  " + p2);
        if( p1 ==null || p2 == null || p1.length() == 0 || p2.length() == 0)
            return false;
        else
            return true;
//        if(p1.equals(p2) || p1.length() == 0 || p2.length() == 0)
//            return false;
//        else
//            return true;
    }
}
