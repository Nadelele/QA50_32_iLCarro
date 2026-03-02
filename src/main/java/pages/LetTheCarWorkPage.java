package pages;

import dto.Car;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;

public class LetTheCarWorkPage extends BasePage {

    public LetTheCarWorkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "pickUpPlace")
    WebElement inputCity;
    @FindBy(id = "make")
    WebElement inputManufacturer;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(id = "fuel")
    WebElement inputFuel;
    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputClass;
    @FindBy(id = "serialNumber")
    WebElement inputRegistrationNumber;
    @FindBy(id = "price")
    WebElement inputPrice;
    @FindBy(id = "about")
    WebElement textAreaAbout;
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement btnSubmit;

    public void typeAddCarForm(Car car) {
        inputCity.sendKeys(car.getCity());
        inputManufacturer.sendKeys(car.getManufacturer());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        inputFuel.sendKeys(car.getFuel());
        inputSeats.sendKeys(String.valueOf(car.getSeats()));
        inputClass.sendKeys(car.getCarClass());
        inputRegistrationNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(String.valueOf(car.getPricePerDay()));
        textAreaAbout.sendKeys(car.getAbout());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type = 'submit']\").removeAttribute(\"disabled\")");
        btnSubmit.click();
    }

}
