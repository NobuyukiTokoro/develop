package develop.common;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtil {

  public static void setData() {

  }

  public static String getData() {
    return "";
  }

  public static void clear(HttpServletRequest req) {
    HttpSession session = req.getSession();
    session.invalidate();
  }

}
