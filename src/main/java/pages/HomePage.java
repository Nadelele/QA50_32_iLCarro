package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;
import utils.enums.MenuItem;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        getPage(PropertiesReader.getProperty("base.properties", "baseUrl"));
    }

    @FindBy(xpath = "//a[contains(@href,'/login')]")
    WebElement btnLogin;

    @FindBy(xpath = "//a[contains(@href, '/registration')]")
    WebElement btnRegistration;

    @FindBy(xpath = "//a[contains(@href, '/let-car-work')]")
    WebElement btnLetCarWork;

    @FindBy(id = "city")
    WebElement inputCity;
    @FindBy(id = "dates")
    WebElement inputDates;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement btnYearCalendar;

    public void clickBtnLogin() {
        btnLogin.click();
    }

    public void clickBtnRegistration() {
        btnRegistration.click();
    }

    public void typeSearchCarForm(String city, LocalDate startDate, LocalDate endDate, Boolean isNegative) {
        inputCity.sendKeys(city);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String dates = startDate.format(formatter) + " - " + endDate.format(formatter);
        inputDates.sendKeys(dates);
        if (!isNegative) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector(\"button[type = 'submit']\").removeAttribute(\"disabled\")");
        }
    }

    public void clickBtnYalla() {
        clickWait(btnYalla, 3);
    }

    private void typeCalendar(LocalDate date) {
        btnYearCalendar.click();
        //td[@aria-label='2026']
        String year = Integer.toString(date.getYear());
        WebElement btnYear = driver.findElement(By.
                xpath("//td[@aria-label='" + year + "']"));
        btnYear.click();
        //td[@aria-label='March 2026']
        String month = createMonth(date.getMonth().toString());
        WebElement btnMonth = driver.findElement(By.
                xpath("//td[@aria-label='" + month + " " + year + "']"));
        btnMonth.click();
        //String day = Integer.toString(date.getDayOfMonth());
        String day = String.valueOf(date.getDayOfMonth());
        WebElement btnDay = driver.findElement(By.
                xpath("//td[@aria-label='" + month + " " + day + ", " + year + "']"));
        btnDay.click();
    }

    public void typeSearchFormWithCalendar
            (String city, LocalDate startDate, LocalDate endDate) {
        inputCity.sendKeys(city);
        inputDates.click();
        typeCalendar(startDate);
        typeCalendar(endDate);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type = 'submit']\").removeAttribute(\"disabled\")");

    }

    private String createMonth(String month) {
        StringBuilder res = new StringBuilder();
        return res.append(month.substring(0, 1).toUpperCase())
                .append(month.substring(1).toLowerCase()).toString();
    }

    public Boolean clickMenuItem(MenuItem item, String title){
        driver.findElement(By.xpath(item.getLocator())).click();
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleContains(title));
    }
    public boolean isMenuItemDisplayed(MenuItem item){
        return !driver.findElements(By.xpath(item.getLocator())).isEmpty();
    }
}
