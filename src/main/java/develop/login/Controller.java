package develop.login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class Controller extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    Action action = new Action();
    response.getWriter().println(action.getClass().getPackage().getName());
    PrintWriter out = response.getWriter();

    try {
      //接続
      InitialContext ic = new InitialContext();
      DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/develop");
      Connection con = ds.getConnection();
      PreparedStatement st = con.prepareStatement("SELECT * FROM user");
      ResultSet rs = st.executeQuery();

      while (rs.next()){
        out.println("id = " + rs.getInt("id"));
        out.println("password = " + rs.getString("password"));
        out.println("login_name = " + rs.getString("login_name"));
        out.println("salt = " + rs.getString("salt"));
        out.println("is_valid = " + rs.getInt("is_valid"));
      }

      st.close();
      con.close();
    } catch (Exception e){
      e.printStackTrace(out);
    }

  }
}