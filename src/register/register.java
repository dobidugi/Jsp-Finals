package login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Service.UserService;
import common.User;
import common.UserValidator;

@WebServlet("/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher page = req.getRequestDispatcher("register.jsp");
        req.setCharacterEncoding("utf-8");
        User user = new User();
        user.setId(req.getParameter("id"));
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));
        user.setPassword2(req.getParameter("password2"));
        user.setPhone(req.getParameter("phone"));
        user.setAddress(req.getParameter("address"));
        UserValidator uv =new UserValidator(user);

        if(uv.isValidRegisterUser()) { // 폼정보를 모두 입력하였슴.
            String pw1 = user.getPassword();
            String pw2 = user.getPassword2();
            if(
                    !passwordCheck(pw1, pw2) && !pw1.equals(pw2)
            ) {
                System.out.println("패스어드 불일치");
                req.setAttribute("error","패스워드 불일치");
                page.forward(req,resp);
                return;
            }
            UserService service = new UserService();
            service.register(user);
            System.out.println("데이터 입력 완벽");
        } else {
            System.out.println("데이터 모두입력안됨");
            req.setAttribute("error","모두 입력해주세요");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;

        }

        req.getRequestDispatcher("register.jsp").forward(req,resp);
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
