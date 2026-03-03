package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.enums.FooterMenuItem;

public class NavigationTests extends AppManager {
    @Test
    public void iconFacebookNavigation() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickSocialNetIcon(FooterMenuItem.ICON_FACEBOOK, "Facebook"));
    }
}
