package cn.shukejian.tomcat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet 3.0 写法 示例
 */
@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        String name = req.getParameter("name");
        System.out.println("name:" + name);
        //rep.setHeader("Content-type", "text/html;charset=UTF-8");
        rep.setCharacterEncoding("UTF-8");
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = rep.getWriter();
        writer.println("Hello," + name);
    }
}
