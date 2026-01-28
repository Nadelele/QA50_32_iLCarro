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

    public boolean isTextInPopUpMessagePresent(String text) {
        return isTextElementPresentWait(message, text);
    }

}
