package com.williamhill.sports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Marek on 5/5/2017.
 */
public class PlaceBetTest {
    public WebDriver driver;
    HomePage homePage;
    BetEventPage betEventPage;

    @BeforeTest
    public void setup() {
        driver = BrowserFactory.getBrowser("Chrome");
        driver.get("http://sports.williamhill.com/betting/en-gb");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void placeBetTest() {
        betEventPage = homePage
                .selectEventType("football")
                .selectFirstEvent()
                .betOnHomeTeam()
                .placeBet("0.05");

        /* Example of select event by team names method usage */
       /*  betEventPage = homePage
                 .selectEventType("football")
                 .selectEvent("Liverpool","Southampton")
                 .betOnHomeTeam()
                 .placeBet("0.05");*/

        Assert.assertTrue(driver.findElement(betEventPage.getPlaceBetErrorMessage()).isDisplayed());
    }
}
