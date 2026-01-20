package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
    static   WebDriver driver;

    protected BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void getPage(String text) {
        driver.get(text);
    }
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
