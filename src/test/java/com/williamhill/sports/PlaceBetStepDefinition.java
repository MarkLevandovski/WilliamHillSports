package com.williamhill.sports;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Marek on 5/5/2017.
 */
public class PlaceBetStepDefinition {
    public WebDriver driver;
    HomePage homePage;
    EventPage eventPage;

    @Given("^User is on Home Page$")
    public void user_is_on_home_page() {
        driver = BrowserFactory.getBrowser("Chrome");
        driver.get("http://sports.williamhill.com/betting/en-gb");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @When("^User selects \"([^\"]*)\" event$")
    public void user_selects_event(String eventType) {
        eventPage = homePage.selectEventType(eventType).selectFirstEvent();
    }

    @When("^User bet on Home team to win$")
    public void user_bet_on_home_team_to_win() {
        eventPage.betOnHomeTeam();
    }

    @When("^User sets \"([^\"]*)\" amount of the bet and clicks Place bet$")
    public void user_sets_amount_of_the_bet(String amount) {
        eventPage.placeBet(amount);
    }

    @Then("^Error Message is displayed$")
    public void error_message_is_displayed() {
        Assert.assertTrue(driver.findElement(eventPage.getPlaceBetErrorMessage()).isDisplayed());
    }
}
