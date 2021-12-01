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

@WebServlet("/findpw")
public class Password extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("findpw.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher failPage = req.getRequestDispatcher("findpw.jsp");
        RequestDispatcher successPage = req.getRequestDispatcher("resetpw.jsp");
        User user = new User(req);
        UserValidator uv = new UserValidator(user);

        if(!uv.isValidFindUserPw()) {
            req.setAttribute("error", Error.FindUserInfo.EMPTY_FORM);
            failPage.forward(req, resp);
            return;
        }

        try {
            boolean res = user.findPw();
            if(res) {
                HttpSession session = req.getSession(); // 안전하게 세션에 userid , name , phone을 넣고 비밀번호 변경페이지로 이동
                session.setAttribute("is_login","false");
                session.setAttribute("userid",user.getId());
                session.setAttribute("name",user.getName());
                session.setAttribute("phone",user.getPhone());
                successPage.forward(req, resp);
            }


        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            failPage.forward(req,resp);
        }
    }
}
