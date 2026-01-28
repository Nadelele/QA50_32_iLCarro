package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@formcontrolname = 'email']")
    WebElement fieldEmail;

    @FindBy(xpath = "//input[@formcontrolname = 'password']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement btnSubmit;

    public void typeLoginForm(User user) {
        fieldEmail.sendKeys(user.getEmail());
        fieldPassword.sendKeys(user.getPassword());
    }

    public void clickBtnSubmit() {
        btnSubmit.click();
    }

}
