package pages;

import dto.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.enums.FuelTypes;

import java.io.File;

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
    WebElement selectFuel;
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
    @FindBy(id = "photos")
    WebElement inputImage;
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement btnSubmit;

    public void typeAddCarForm(Car car) {
        inputCity.sendKeys(car.getCity());
        inputManufacturer.sendKeys(car.getManufacturer());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        typeFuel(car.getFuel());
        inputSeats.sendKeys(String.valueOf(car.getSeats()));
        inputClass.sendKeys(car.getCarClass());
        inputRegistrationNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(String.valueOf(car.getPricePerDay()));
        textAreaAbout.sendKeys(car.getAbout());
    }
    private void typeFuel(FuelTypes fuelType){
        selectFuel.click();
        driver.findElement(By.xpath(fuelType.getLocator())).click();
    }
    public void typeImage(String fileName){
        inputImage.sendKeys(new File("src/test/resources/" + fileName).getAbsolutePath());
    }
    public void clickBtnSubmit(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type = 'submit']\").removeAttribute(\"disabled\")");
        btnSubmit.click();
    }

}
