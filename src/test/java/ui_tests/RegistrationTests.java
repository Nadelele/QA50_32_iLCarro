package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PopupPage;
import pages.RegistrationPage;
import static utils.UserFactory.*;

public class RegistrationTests extends AppManager {
    RegistrationPage registrationPage;

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

}
