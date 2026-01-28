package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    static WebDriver driver;

    protected BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//div[@class='error']")
    List<WebElement> listErrors;

    public boolean isTextInErrorPresent(String text) {
//        if (listErrors == null || listErrors.isEmpty())
//            return false;
//        for (WebElement element: listErrors){
//            if(element.getText().contains(text))
//                return true;
//        }
//        return false;
        return listErrors.stream().anyMatch(e -> e.getText().contains(text));
    }


    protected void getPage(String text) {
        driver.get(text);
    }

      public boolean isTextElementPresentWait(WebElement element, String text) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
