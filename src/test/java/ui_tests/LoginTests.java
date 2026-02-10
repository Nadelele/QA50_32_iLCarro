package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopupPage;
import utils.RetryAnalyzer;

import static utils.PropertiesReader.*;

public class LoginTests extends AppManager {
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void goToLoginPage(){
        new HomePage(getDriver()).clickBtnLogin();
        loginPage  = new LoginPage(getDriver());
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginPositiveTest() {
        User user = User.builder()
                .email(getProperty("base.properties", "login"))
                .password(getProperty("base.properties", "password"))
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnSubmit();
        //Assert.assertTrue(loginPage.isLoggedInDisplayed());
        Assert.assertTrue(new PopupPage(getDriver())
                .isTextInPopUpMessagePresent("Logged in success"));
    }
    @Test
    public void loginNegativeTest_Password_WOSpecialSymbol(){
        User user = User.builder()
                .email(getProperty("base.properties", "login"))
                .password("BSas124")
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnSubmit();
        Assert.assertTrue(new PopupPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }
    @Test
    public void loginNegativeTest_EmailPassEmpty(){
        User user = User.builder()
                .email(" ")
                .password("")
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnSubmit();
        softAssert.assertTrue(loginPage.isTextInErrorPresent("Email is required"), "validate email!");
        softAssert.assertTrue(loginPage.isTextInErrorPresent("Password is required"), "validate password");
        softAssert.assertAll();
    }

}
