package pages;

import core.configuration.UIConfig;
import locators.Locators;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ResearchPage extends BasePage{
    private Locators locators;

    public ResearchPage(WebDriver driver) {
        super(driver);
        driver.get(UIConfig.getResearchPage());
        locators = new Locators();
    }
    public File getDownloadFile(String fileName) {
        String expectedFileName = fileName;
        File downloadedFile = new File(System.getProperty("user.home") + "/Downloads/" + expectedFileName);

        int timeout = 60;
        int waitTime = 0;
        while (!downloadedFile.exists() && waitTime < timeout) {
            try {
                Thread.sleep(1000);
                waitTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return downloadedFile;
    }

}
