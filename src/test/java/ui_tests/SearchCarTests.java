package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
//import utils.TestNGListener;

import java.time.LocalDate;
//@Listeners(TestNGListener.class)



public class SearchCarTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage;

    @BeforeMethod
    public void openHomePage(){
        homePage = new HomePage(getDriver());
    }

    @Test
    public void searchCarPositiveTest(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now().plusDays(2);
        LocalDate endDate = startDate.plusDays(3);
        homePage.typeSearchCarForm(city, startDate, endDate, false);
        homePage.clickBtnYalla();
        Assert.assertTrue(homePage.urlContains("results", 4));

    }
    @Test
    public void searchCarPositiveTestWithCalendar() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate
                .of(2026, 3, 12);
        LocalDate endDate = LocalDate
                .of(2026, 3, 22);
        homePage.typeSearchFormWithCalendar(city, startDate, endDate);
        homePage.clickBtnYalla();
        Assert.assertTrue(homePage.urlContains
                 ("results", 5));
    }
    @Test
    public void searchCarNegativeTest_StartDateSameEndDate(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();
        homePage.typeSearchCarForm(city, startDate, endDate, false);
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("City is required"), "city is required");
        softAssert.assertTrue(homePage.isTextInErrorPresent("You can't book car for less than a day")
                , "not 1 day");
        softAssert.assertAll();

    }
    @Test
    public void searchCarNegativeTest_StartDateBeforeToday(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now().minusDays(1);
        LocalDate endDate = LocalDate.now();
        homePage.typeSearchCarForm(city, startDate, endDate, false);
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("City is required"), "city is required");
        softAssert.assertTrue(homePage.isTextInErrorPresent("You can't pick date before today")
                , "not date before today");
        softAssert.assertAll();

    }
    @Test
    public void searchCarNegativeTest_StartDateAfterEndDate(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now().plusDays(3);
        LocalDate endDate = LocalDate.now().plusDays(1);
        homePage.typeSearchCarForm(city, startDate, endDate, false);
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("City is required"), "city is required");
        softAssert.assertTrue(homePage.isTextInErrorPresent("Second date must be after first date")
                , "Second date must be after first date");
        softAssert.assertAll();

    }
    @Test(expectedExceptions =  java.time.DateTimeException.class)
    public void searchCarNegativeTest_DateNotValid(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026, 2, 30);
        LocalDate endDate = LocalDate.now().plusDays(1);
        homePage.typeSearchCarForm(city, startDate, endDate, false);
        homePage.clickBtnYalla();
    }
    @Test(expectedExceptions =  org.openqa.selenium.TimeoutException.class)// - вариант обработки исключения
    public void searchCarNegativeTest_EmptyField_City(){
        LocalDate startDate = LocalDate.now().plusDays(2);
        LocalDate endDate = startDate.plusDays(3);
        homePage.typeSearchCarForm("", startDate, endDate, true);
        homePage.clickBtnYalla();
    }
    @Test
    public void searchCarNegativeTest_EmptyField_CityValidateError(){
        String city = "";
        LocalDate startDate = LocalDate.now().plusDays(2);
        LocalDate endDate = startDate.plusDays(3);
        homePage.typeSearchCarForm(city, startDate, endDate, true);
        Assert.assertTrue(homePage
                .isTextInErrorPresent("City is required"));
    }
}
