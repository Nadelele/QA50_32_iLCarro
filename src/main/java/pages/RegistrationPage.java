package pages;

import dto.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    WebElement fieldNameRegistration;
    @FindBy(id = "lastName")
    WebElement fieldLastNameRegistration;
    @FindBy(id = "email")
    WebElement fieldEmailRegistration;
    @FindBy(id = "password")
    WebElement fieldPasswordRegistration;
    @FindBy(id = "terms-of-use")
    WebElement checkBoxAgreeTermsOfUse;
    @FindBy(xpath = "//button[text() = 'Y’alla!']")
    WebElement btnSubmitYalla;
    @FindBy(xpath = "//h2[text()='You are logged in success']")
    WebElement registrationSuccessPopUp;

    public void typeRegistrationForm(User user) {
        fieldEmailRegistration.sendKeys(user.getEmail());
        fieldPasswordRegistration.sendKeys(user.getPassword());
        fieldNameRegistration.sendKeys(user.getFirstName());
        fieldLastNameRegistration.sendKeys(user.getLastName());
    }

    public void clickBtnSubmitYalla() {
        btnSubmitYalla.click();
    }

    public void setCheckBoxAgreeTermsOfUse() {
        if (!checkBoxAgreeTermsOfUse.isSelected()) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", checkBoxAgreeTermsOfUse);
        }
    }
    public boolean isRegisteredDisplayed() {
        return isElementDisplayed(registrationSuccessPopUp);
    }
}
