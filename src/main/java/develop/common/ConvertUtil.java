package develop.common;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;

public class ConvertUtil {

  public static String sha256(String word) {
    return String.valueOf(Hex.encodeHex(DigestUtils.sha256(word)));
  }

  public static String getErrorMesseage(String error_cord) {
  String result = "";
    try {
      String path = "/usr/local/Cellar/tomcat/9.0.10/libexec/webapps/develop/const/errorCode.json";
      File file = new File(path);
      if(!file.exists()) {
        return "UNEXPECTED ERROR";
      }
      ObjectMapper mapper = new ObjectMapper();
      JsonNode root = mapper.readTree(new File(path));
      result = root.get(error_cord).asText();

    } catch (IOException e) {
      //握りつぶしているから後で考える。
    }
    return result;
  }

}
