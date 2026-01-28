package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        getPage("https://ilcarro.web.app/search");
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
