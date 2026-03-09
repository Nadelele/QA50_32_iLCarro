package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.enums.FooterSocialMenuItem;
import utils.enums.FooterPagedMenuItems;
import utils.enums.HeaderMenuItem;

public class NavigationNonAuthorizedTests extends AppManager {
    //Header Pages Navigation Menu
    @Test(groups = "smoke")
    public void headerMenuNavigation_Search() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.SEARCH, "Search"));
    }
    @Test
    public void headerMenuNavigation_TermsOfUse() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.TERMS_OF_USE, "Terms of use"));
    }
    @Test(groups = "smoke")
    public void headerMenuNavigation_SignUp() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.SIGN_UP, "Registration"));
    }
    @Test(groups = "smoke")
    public void headerMenuNavigation_LogIn() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(HeaderMenuItem.LOGIN, "Login"));
    }

    @Test
    public void headerMenuNavigation_isLetTheCarWorkDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(HeaderMenuItem.LET_THE_CAR_WORK), "'Let your car work' is displayed for unauthorized user");
    }
    @Test
    public void headerMenuNavigation_isLogoutDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(HeaderMenuItem.LOGOUT), "'Log out' is displayed for unauthorized user");
    }
    @Test
    public void headerMenuNavigation_isDeleteAccountDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(HeaderMenuItem.DELETE_ACCOUNT), "'Delete Account' is displayed for unauthorized user");
    }


    //Social Net Footer Icons Menu
    @Test
    public void footerMenuSocialNavigation_Facebook() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterSocialMenuItem.ICON_FACEBOOK, "Facebook"));
    }
    @Test
    public void footerMenuSocialNavigation_Telegram() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterSocialMenuItem.ICON_TELEGRAM, "Telegram Messenger"));
    }
    @Test
    public void footerMenuSocialNavigation_VK() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterSocialMenuItem.ICON_VK, "VK | Welcome!"));
    }
    @Test
    public void footerMenuSocialNavigation_Instagram() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterSocialMenuItem.ICON_INSTAGRAM, "Instagram"));
    }
    @Test
    public void footerMenuSocialNavigation_Slack() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterSocialMenuItem.ICON_SLACK, "Slack | AI Work Platform & Productivity Tools"));
    }
    //Footer Pages Navigation Menu
    @Test
    public void footerMenuPagesNavigation_Search() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.SEARCH, "Search"));
    }
    @Test
    public void footerMenuPagesNavigation_TermsOfUse() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.TERMS_OF_USE, "Terms of use"));
    }
    @Test
    public void footerMenuPagesNavigation_SignUp() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.SIGN_UP, "Registration"));
    }
    @Test
    public void footerMenuPagesNavigation_LogIn() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickMenuItem(FooterPagedMenuItems.LOGIN, "Login"));
    }

    @Test
    public void footerMenuPagesNavigation_isLetTheCarWorkDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(FooterPagedMenuItems.LET_THE_CAR_WORK), "'Let your car work' is displayed for unauthorized user");
    }
    @Test
    public void footerMenuPagesNavigation_isLogoutDisplayed() {
        Assert.assertFalse(new HomePage(getDriver())
                .isMenuItemDisplayed(FooterPagedMenuItems.LOGOUT), "'Logout' is displayed for unauthorized user");
    }


}
