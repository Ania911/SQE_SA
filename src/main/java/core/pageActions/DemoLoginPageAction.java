package core.pageActions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DemoLoginPage;

public class DemoLoginPageAction extends DemoLoginPage {

    public DemoLoginPageAction(WebDriver driver) {
        super(driver);
    }

    @Step("User log in to the system")
    public DemoLoginPageAction userLogin(String email, String pass) {
        enterUserEmail(email);
        enterUserPass(pass);
        return this;
    }
}
