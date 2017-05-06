package com.williamhill.sports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Marek on 5/5/2017.
 * Class represents Place Bet page.
 */
public abstract class BetEventPage {
    public final static Logger LOGGER= LoggerFactory.getLogger(BetEventPage.class);

    protected WebDriver driver;

    public BetEventPage(WebDriver driver) {
        this.driver = driver;
    }

    /* Page objects */
    private By placeBetButton = By.id("place-bet-button");
    private By betAmountInput = By.cssSelector(".betslip-selection__stake-input");
    private By placeBetErrorMessage = By.id("place-bet-error");
    private By totalStakePrice = By.id("total-stake-price");

    public By getPlaceBetErrorMessage() {
        return placeBetErrorMessage;
    }

    /**
     * Method sets amount of the bet and clicks Place Bet
     * @param amount - amount of money we want to bet
     * @return Event Page
     */
    public BetEventPage placeBet(String amount) {
        /* If mobile version of Chrome is used, execute this instruction */
        if (BrowserFactory.browserType != null && BrowserFactory.browserType.equals("MOBILE")) {

            /* Open keyboard */
            driver.findElement(betAmountInput).click();

            /* Divide amount value into single chars and then click on button on the keyboard*/
            char[] singleChar = amount.toCharArray();
            for (int i = 0; i < singleChar.length; i++) {
                driver.findElement(By.cssSelector("button[data-value='" + singleChar[i] + "']")).click();
            }
        } else {
             /* Enter amount*/
            driver.findElement(betAmountInput).sendKeys(amount);
        }

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for amount to be fully entered...");
                return driver.findElement(betAmountInput).getAttribute("value").equals(amount);
            }
        });

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for total stake price...");
                return driver.findElement(totalStakePrice).getText().equals(amount);
            }
        });

        /*Click the Place Bet button*/
        driver.findElement(placeBetButton).click();
        return this;
    }
}
