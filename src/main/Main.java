package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("euc-kr");
        PrintWriter print = resp.getWriter();
        print.write("<html><head><title>ServletTest</title></head>");
        print.write("<body>");
        print.write("서블릿 테스트");
        print.write("</body></html>");
        print.close();
    }
}
