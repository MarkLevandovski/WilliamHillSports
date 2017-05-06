package com.williamhill.sports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Marek on 5/5/2017.
 * Class represents Event Page
 */
public class EventPage extends BetEventPage {
    public final static Logger LOGGER= LoggerFactory.getLogger(EventPage.class);

    public EventPage(WebDriver driver) {
        super(driver);
    }

    /* Page objects */
    private By eventBetButtons = By.cssSelector(".btmarket__selection>button");
    private By betSlipButton = By.cssSelector(".toolbar__icon.icon-bet-slip");
    private By betAmountInput = By.cssSelector(".betslip-selection__stake-input");


    /**
     * Method that bet on Home team
     * @return Event Page
     */
    public EventPage betOnHomeTeam() {
        new Actions(driver).click(driver.findElements(eventBetButtons).get(0)).perform();

        /* If mobile version of Chrome is used, execute this instruction*/
        if (BrowserFactory.browserType != null && BrowserFactory.browserType.equals("MOBILE")) {
            SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    LOGGER.info("Waiting for Bet-slip button on toolbar Page....");
                    return driver.findElement(betSlipButton) != null;
                }
            });
            /* Click the Bet Slip button */
            new Actions(driver).click(driver.findElement(betSlipButton)).perform();
        }

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Bet Event Page....");
                return driver.findElement(betAmountInput) != null;
            }
        });
        return this;
    }
}
