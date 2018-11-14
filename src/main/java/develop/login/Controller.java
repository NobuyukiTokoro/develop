package develop.login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import develop.common.SessionUtil;

@WebServlet("/login")
public class Controller extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    SessionUtil.clear(req);
    String path = "view/login/index.jsp";
    RequestDispatcher dispatcher = req.getRequestDispatcher(path);
    dispatcher.forward(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    try {
      Action action = new Action(req.getParameter("login_id"), req.getParameter("password"));

      //trueなら次のページへ
      //action.execute();

      //画面で確認用だから後で消す!!
      HashMap<String, String> hoge = action.execute();

      for (String v : hoge.values()) {
        out.println(v);
      }

      //ここまで

    } catch(Exception e) {
      out.println(e.getMessage());
      //e.printStackTrace(out);
    }



  }









}