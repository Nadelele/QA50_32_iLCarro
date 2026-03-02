package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends BasePage {
    public PopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//mat-dialog-container//h2")
    WebElement message;
    @FindBy(xpath = "//button[@type = 'button']")
    WebElement btnOk;

    public boolean isTextInPopUpMessagePresent(String text) {
        return isTextElementPresentWait(message, text);
    }

    public void btnOkClick() {
        btnOk.click();
    }
}
