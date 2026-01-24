package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests extends AppManager {
    @Test
    public void registrationPositiveTest() {
        int i  = new Random().nextInt(1000);
        User user = User.builder()
                .email("test" + i + "@gmail.com")
                .password("BSas124!")
                .firstName("NameNL")
                .lastName("LastNameNL")
                .build();
        System.out.println(user);
        HomePage homePage = new HomePage(getDriver());
        homePage.getHomePage();
        homePage.clickBtnRegistration();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnSubmitYalla();
        Assert.assertTrue(registrationPage.isRegisteredDisplayed());

    }
}
