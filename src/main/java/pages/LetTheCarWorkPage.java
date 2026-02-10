package pages;

import org.openqa.selenium.WebDriver;
import utils.PropertiesReader;

public class LetTheCarWorkPage extends BasePage{
    public LetTheCarWorkPage(WebDriver driver) {
        super(driver);
        getPage(PropertiesReader.getProperty("base.properties", "baseUrl"));
    }
}
