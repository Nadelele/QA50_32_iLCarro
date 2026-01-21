package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTests extends AppManager {
    @Test
    public void registrationPositiveTest() {
        User user = User.builder()
                .email("testnl2@gmail.com")
                .password("BSas124!")
                .firstName("NameNL")
                .lastName("LastNameNL")
                .build();
        System.out.println(user);
        HomePage homePage = new HomePage(getDriver());
        homePage.getHomePage();
        homePage.clickBtnRegistration();
        RegistrationPage registrationPage= new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.setCheckBoxAgreeTermsOfUse();
        registrationPage.clickBtnSubmitYalla();
       Assert.assertTrue(registrationPage.isRegisteredDisplayed());

    }
}
