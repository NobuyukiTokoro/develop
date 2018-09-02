package develop.userlist;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userlist")
public class Controller extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Action action = new Action();
    response.getWriter().println(action.getClass().getPackage().getName());

  }
}