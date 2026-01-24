package pages;

import dto.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

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
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBoxAgree;
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

//    public void setCheckBoxAgreeTermsOfUse() {
//        if (!checkBoxAgreeTermsOfUse.isSelected()) {
//            ((JavascriptExecutor) driver)
//                    .executeScript("arguments[0].click();", checkBoxAgreeTermsOfUse);
//        }
//    }

    public boolean isRegisteredDisplayed() {
        return isElementDisplayed(registrationSuccessPopUp);
    }

    public void clickCheckBoxWithActions() {
        int y = checkBoxAgree.getSize().getHeight();
        int x = checkBoxAgree.getSize().getWidth();
        System.out.println(x + "x" + y);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBoxAgree, 1, 10).click().perform();
    }
}
