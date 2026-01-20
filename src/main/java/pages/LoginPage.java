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

    @FindBy(xpath = "//h2[text()='Logged in success']")
    WebElement loginSuccessPopUp;

    public void typeLoginForm(User user) {
        fieldEmail.sendKeys(user.getEmail());
        fieldPassword.sendKeys(user.getPassword());
    }

    public void getLoginPage() {
        getPage("https://ilcarro.web.app/login");
    }

    public void clickBtnSubmit() {
        btnSubmit.click();
    }

    public void enterEmail(String text) {
        enterText(fieldEmail, text);
    }

    public void enterPass(String text) {
        enterText(fieldPassword, text);
    }

    public String getLoginSubmitText() {
        return loginSuccessPopUp.getText();
    }

    public boolean isLoggedInDisplayed() {
        return isElementDisplayed(loginSuccessPopUp);
    }

}
