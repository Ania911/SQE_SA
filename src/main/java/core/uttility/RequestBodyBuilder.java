package core.uttility;

import java.util.HashMap;
import java.util.Map;

public class RequestBodyBuilder {
    public static Map<String, Object> buildUserRequestBody(String username, String pass) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("pass", pass);
        return requestBody;
    }
}
