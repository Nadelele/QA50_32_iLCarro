package utils.enums;

public enum FooterPagedMenuItems implements MenuItem{
    SEARCH("//div[@class='page-links']//a[text()='Search']"),
    LET_THE_CAR_WORK("//div[@class='page-links']//a[text()='Let the car work']"),
    TERMS_OF_USE("//div[@class='page-links']//a[text()='Terms of use']"),
    SIGN_UP("//div[@class='page-links']//a[text()='Sign up']"),
    LOGIN("//div[@class='page-links']//a[text()='Log in']"),
    LOGOUT("//div[@class='page-links']//a[text()='Log out']");


    private final String locator;

    FooterPagedMenuItems(String locator) {
        this.locator = locator;
    }
    @Override
    public String getLocator() {
        return locator;
    }
}
