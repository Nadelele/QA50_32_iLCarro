package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PopupPage;
import pages.RegistrationPage;
import utils.enums.FooterPagedMenuItems;
import utils.enums.HeaderMenuItem;
import static utils.PropertiesReader.getProperty;


public class NavigationAuthorizedTests extends AppManager {
    LoginPage loginPage;
    HomePage homePage;
    PopupPage popupPage;

    @BeforeMethod
    public void goToLoginPage(){
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
    }

    //Header Menu
    @Test
    public void headerMenuNavigation_Search() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.SEARCH, "Search"));
    }
    @Test
    public void headerMenuNavigation_LetTheCarWork() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.LET_THE_CAR_WORK, "Let the car work!"));
    }
    @Test
    public void headerMenuNavigation_TermsOfUse() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.TERMS_OF_USE, "Terms of use"));
    }
    @Test
    public void headerMenuNavigation_Logout() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.LOGOUT, "Search"));
    }
    @Test
    public void headerMenuNavigation_DeleteAccount() {
        homePage.clickButtonHeader(HeaderMenuItem.DELETE_ACCOUNT);
        Assert.assertTrue(new PopupPage(getDriver())
                .isTextInPopUpMessagePresent("Are you sure that you want delete account? You cant undo this action."));
    }
    @Test
    public void headerMenuNavigation_isSignUpDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(HeaderMenuItem.SIGN_UP));
    }
    @Test
    public void headerMenuNavigation_isLogInDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(HeaderMenuItem.LOGIN));
    }

    //Footer Pages Navigation Menu
    @Test
    public void footerMenuPagesNavigation_Search() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.SEARCH, "Search"));
    }
    @Test
    public void footerMenuPagesNavigation_LetTheCarWork() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.LET_THE_CAR_WORK, "Let the car work!"));
    }
    @Test
    public void footerMenuPagesNavigation_TermsOfUse() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.TERMS_OF_USE, "Terms of use"));
    }
    @Test
    public void footerMenuPagesNavigation_Logout() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.LOGOUT, "Search"));
    }
    @Test
    public void footerMenuPagesNavigation_isSignUpDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(FooterPagedMenuItems.SIGN_UP));
    }
    @Test
    public void footerMenuPagesNavigation_isLogInDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(FooterPagedMenuItems.LOGIN));
    }


}
