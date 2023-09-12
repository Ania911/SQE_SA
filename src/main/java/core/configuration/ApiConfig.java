package core.configuration;


public class ApiConfig {

    public static final String baseURI = "http://localhost:8080";

    // User controller
    public static String getAdminUser() {
        return "/api/v1/user/superadmin";
    }

    public static String getAllUser() {
        return "/api/v1/use";
    }

    public static String crudSpecifiedUser() {
        return "/api/v1/user";
    }

    public static String exportAllUsers() {
        return "/api/v1/user/export?view=csv";
    }


}
