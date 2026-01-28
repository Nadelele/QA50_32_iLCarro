package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.PopupPage;
import pages.RegistrationPage;
import static utils.UserFactory.*;

public class RegistrationTests extends AppManager {
    RegistrationPage registrationPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void goToRegistrationPage(){
        new HomePage(getDriver()).clickBtnRegistration();
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void registrationPositiveTest() {
        User user = positiveUser();
        System.out.println(user);
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnSubmitYalla();
        Assert.assertTrue(new PopupPage(getDriver())
                .isTextInPopUpMessagePresent("You are logged in success"));
    }
    @Test
    public void registrationNegativeTest_UserAlreadyExists() {
        User user = positiveUser();
        user.setEmail("sima_simonova370@gmail.com");
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnSubmitYalla();
        Assert.assertTrue(new PopupPage(getDriver())
                .isTextInPopUpMessagePresent("User already exists"));
    }
    @Test
    public void registrationNegativeTest_Password_WOSpecialSymbol() {
        User user = positiveUser();
        user.setPassword("QWEasd1");
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnSubmitYalla();
        softAssert.assertTrue(registrationPage
                .isTextInErrorPresent("Password must contain 1 uppercase letter, 1 lowercase letter, " +
                        "1 number and one special symbol of [@$#^&*!]"), "SpecSymbols!");
        softAssert.assertTrue(registrationPage.isTextInErrorPresent("Password must contain minimum 8 symbols"), "8 symbols!");
        softAssert.assertAll();
    }

}
