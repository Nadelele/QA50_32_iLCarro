package pages;

import org.openqa.selenium.WebDriver;
import utils.PropertiesReader;

public class TermsOfUsePage extends BasePage{
    public TermsOfUsePage(WebDriver driver) {
        super(driver);
        getPage(PropertiesReader.getProperty("base.properties", "baseUrl"));
    }

}
