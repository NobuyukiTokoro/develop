import java.io.IOException;
import common.Template;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet( urlPatterns = {"/form"} )
public class Form extends HttpServlet {

    public void doPost ( HttpServletRequest request,
                        HttpServletResponse response
                      ) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");

        Template.header(out);
        out.println("<p>日本語対応</p>");
        out.println("<p>" + user + "</p>");
        Template.footer(out);
    }

}

