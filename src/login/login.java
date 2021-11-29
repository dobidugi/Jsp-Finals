package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            String jdbcurl = "jdbc:mysql://localhost:3306/test";
            String id ="root";
            String pw = "1234";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcurl,id,pw);
            System.out.println("dbgood");
        } catch (Exception e) {
            System.out.println("XX");
            e.printStackTrace();
        }
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
