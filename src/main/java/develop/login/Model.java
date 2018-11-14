package develop.login;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Model {
  private DataSource ds = null;
  private Connection con = null;
  private PreparedStatement st = null;
  private ResultSet rs = null;

  Model() throws Exception {
    this.ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/develop");
  }

  void openConnection() throws Exception {
    this.con = this.ds.getConnection();
  }

  void closeConnection() throws Exception {
    this.con.close();
  }

  void openPreparedStatement(String query) throws Exception {
    this.st = this.con.prepareStatement(query);
  }

  void closePreparedStatement() throws Exception {
    this.st.close();
  }

  protected HashMap<String, String> getUser(String login_name) throws Exception {
    String query = String.format("SELECT * FROM user WHERE login_name = '%s' AND is_valid = '1'", login_name);
    openConnection();
    openPreparedStatement(query);
    this.rs = this.st.executeQuery();
    HashMap<String, String> sql_result = new HashMap<String, String>();
    while (rs.next()){
      sql_result.put("password",rs.getString("password"));
      sql_result.put("login_name",rs.getString("login_name"));
      sql_result.put("salt",rs.getString("salt"));
    }
    closeConnection();
    closePreparedStatement();
    return sql_result;
  }


}
