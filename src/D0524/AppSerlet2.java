package D0524;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/AppSerlet2")
public class AppSerlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        ServletContext app1 = this.getServletContext();
        ServletContext app2 = req.getServletContext();
        ServletContext app3 = req.getSession().getServletContext();

        System.out.println(app1);
        System.out.println(app2);
        System.out.println(app3);

        System.out.println("=========" + app1.getAttribute("name"));

    }
}
