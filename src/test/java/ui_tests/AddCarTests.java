package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import pages.PopupPage;
import utils.enums.HeaderMenuItem;

import static utils.PropertiesReader.getProperty;
import static utils.CarFactory.positiveCar;

public class AddCarTests extends AppManager {
    LoginPage loginPage;
    LetTheCarWorkPage letTheCarWorkPage;
    PopupPage popupPage;
    HomePage homePage;

    @BeforeMethod
    public void goToLoginPage() {
        new HomePage(getDriver()).clickBtnLogin();
        loginPage = new LoginPage(getDriver());
        User user = User.builder()
                .email(getProperty("base.properties", "login"))
                .password(getProperty("base.properties", "password"))
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnSubmit();
        popupPage = new PopupPage(getDriver());
        popupPage.btnOkClick();
        homePage = new HomePage(getDriver());
        homePage.clickButtonHeader(HeaderMenuItem.LET_THE_CAR_WORK);
        letTheCarWorkPage = new LetTheCarWorkPage(getDriver());
    }

    @Test
    public void addCarPositive() {
        letTheCarWorkPage.typeAddCarForm(positiveCar());
        letTheCarWorkPage.typeImage("car.jpg");
        letTheCarWorkPage.clickBtnSubmit();
        Assert.assertTrue(new PopupPage(getDriver())
                .isTextInPopUpMessagePresent("Your car is successfully added"));
    }
}
