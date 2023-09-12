package core.configuration;


public class ApiConfig {

    public static final String baseURI = "http://localhost:8080";

    public static String getAdminUser() {
        return "/api/v1/user/superadmin";
    }

    public static String getUser() {
        return "/api/v1/user/superadmin";
    }

    public static String getPostsEndpoint() {
        return "/posts";
    }

    public static String getCommentsEndpoint() {
        return "/comments";
    }

}
