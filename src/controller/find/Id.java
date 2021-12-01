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
import java.io.IOException;

@WebServlet("/findid")
public class Id extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("findid.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher failPage = req.getRequestDispatcher("findid.jsp");
        RequestDispatcher successPage = req.getRequestDispatcher("findid.jsp");
        User user = new User(req);
        UserValidator uv = new UserValidator(user);

        if(!uv.isValidFindUserId()) {
            req.setAttribute("error", Error.FindUserInfo.EMPTY_FORM);
            failPage.forward(req, resp);
            return;
        }

        try {
            String res = user.findId();
            req.setAttribute("success", res);
            successPage.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            failPage.forward(req,resp);
        }

    }
}
