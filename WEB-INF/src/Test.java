import java.io.IOException;
import common.Template;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet( urlPatterns = {"/test"} )
public class Test extends HttpServlet {

    public void doGet ( HttpServletRequest request,
                        HttpServletResponse response
                      ) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        Template.header(out);
        out.println("<p>日本語対応</p>");
        out.println("<p>" + new java.util.Date() + "</p>");
        Template.footer(out);
    }

}

