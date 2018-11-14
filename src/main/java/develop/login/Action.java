package develop.login;
import java.util.HashMap;
import develop.common.ConvertUtil;

public class Action {
  private HashMap<String, String> login_info = new HashMap<String, String>();

  Action(String login_id, String password){
    this.login_info.put("login_id", login_id);
    this.login_info.put("input_password", password);
  }

  protected HashMap<String, String> execute() throws Exception {
    try {
      requiredItemCheck();
      Model model = new Model();
      HashMap<String, String> login_user = model.getUser(this.login_info.get("login_id"));
      String db_password = login_user.get("password");
      if(login_user.size() == 0) {
        throw new Exception(ConvertUtil.getErrorMesseage("E003"));
      }

      String password = ConvertUtil.sha256(this.login_info.get("input_password") + login_user.get("salt"));
      if(!password.equals(db_password)) {
        throw new Exception(ConvertUtil.getErrorMesseage("E004"));
      }

      return login_user;
    } catch(Exception e) {
      throw e;
    }

  }

  void requiredItemCheck() throws Exception {
    if (!login_info.containsKey("login_id") || !login_info.containsKey("input_password")){
      throw new Exception(ConvertUtil.getErrorMesseage("E001"));
    }

    for (String v : login_info.values()) {
      if((v.isEmpty()) || (v == null)){
        throw new Exception(ConvertUtil.getErrorMesseage("E002"));
      }
    }

  }

  protected HashMap<String, String> getLoginInfo() {
    return this.login_info;
  }

}
