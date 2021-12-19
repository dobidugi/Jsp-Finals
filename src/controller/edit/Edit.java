package controller.edit;

import common.OrderItem;
import common.User;
import common.UserValidator;
import exception.FindUserException;
import strings.Error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("is_login") == null)
        {
            resp.sendRedirect("/login");
            return;
        }
        req.setCharacterEncoding("utf-8");
        User user = new User(req, session);
        UserValidator uv = new UserValidator(user);

        if(uv.isEditUser()) {
            try {
                user.editInfo();
                ArrayList<OrderItem> list = user.getOrderList();
                req.setAttribute("user",user);
                req.setAttribute("list", list);
                req.setAttribute("success","수정 완료");
            } catch (Exception e) {
                e.printStackTrace();
                throw new FindUserException(Error.Edit.EDIT_ERROR);
            }

        }
        else {
            req.setAttribute("user",user);
            req.setAttribute("error",Error.Edit.EMPTY_FORM);
        }
        req.getRequestDispatcher("myinfo.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/myinfo");
    }
}
