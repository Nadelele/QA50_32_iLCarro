package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;

import static utils.PropertiesReader.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        getPage(PropertiesReader.getProperty("base.properties", "baseUrl"));
    }

    @FindBy(xpath = "//a[contains(@href,'/login')]")
    WebElement btnLogin;

    @FindBy(xpath = "//a[contains(@href, '/registration')]")
    WebElement btnRegistration;

    public void clickBtnLogin() {
        btnLogin.click();
    }

    public void clickBtnRegistration() {
        btnRegistration.click();
    }

}
