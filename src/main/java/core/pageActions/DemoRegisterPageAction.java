package core.pageActions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DemoRegisterPage;

public class DemoRegisterPageAction extends DemoRegisterPage {
    public DemoRegisterPageAction(WebDriver driver) {
        super(driver);
    }

    @Step("Register new user")
    public DemoRegisterPageAction userRegistration(String username, String lastUserName, String pass, String password) {
        enterUserName(username);
        enterLastName(lastUserName);
        enterEmail();
        enterPass(pass);
        confirmPassword(password);
        return this;
    }

    @Step("User log in to the system")
    public DemoRegisterPageAction userLogin(String email, String pass) {
        enterUserEmail(email);
        enterUserPass(pass);
        clickLoginButton();
        return this;
    }
}
