package core.uttility;

import org.apache.commons.lang.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class RequestBodyBuilder {
    public static String generateRandomEmail = generateRandomEmail();
    public static Map<String, Object> buildUserRequestBody(String username, String password) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("accountRole", "USER");
        requestBody.put("defaultProject", "default_personal");
        requestBody.put("email", generateRandomEmail); // Assuming email is based on the username
        requestBody.put("fullName", "Testers");
        requestBody.put("login", username);
        requestBody.put("password", password);
        requestBody.put("projectRole", "CUSTOMER");
        return requestBody;
    }

    public static Map<String, Object> buildTokenRequestBody(String username, String password) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("grant_type", "Basic dWk6dWltYW4=");
        requestBody.put("username", username);
        requestBody.put("password", password);
        return requestBody;
    }

    public static String generateRandomEmail() {
        String randomUsername = RandomStringUtils.randomAlphanumeric(10);
        String randomDomain = RandomStringUtils.randomAlphanumeric(5) + ".com";

        return randomUsername + "@" + randomDomain;
    }


}
