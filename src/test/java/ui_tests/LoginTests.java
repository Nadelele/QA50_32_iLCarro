package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {
    @Test
    public void loginPositiveTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.getHomePage();
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("qa50nl@gmail.com");
        loginPage.enterPass("QWEasd123!");
        loginPage.clickBtnSubmit();
        Assert.assertEquals(loginPage.getLoginSubmitText().trim(), "Logged in success");
    }
}
