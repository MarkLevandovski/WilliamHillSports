package com.williamhill.sports;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Marek on 5/5/2017.
 * Class represents Events List page
 */
public class EventsPage extends BetEventPage {
    public final static Logger LOGGER= LoggerFactory.getLogger(EventsPage.class);
    JavascriptExecutor executor = (JavascriptExecutor)driver;

    public EventsPage(WebDriver driver) {
            super(driver);
        }

    /* Page objects */
    private By marketsContainer = By.cssSelector("#markets-container");
    private By eventBetButtons = By.cssSelector(".btmarket__selection>button");
    List<WebElement> eventsList = driver.findElements(By.cssSelector(".btmarket__link-name"));

    /**
     * Method to select first event from the list
     * @return EventPage
     */
    public EventPage selectFirstEvent() {
        LOGGER.info("Available events:");
        for (int i = 0; i < eventsList.size() ; i++) {
            LOGGER.info(eventsList.get(i).getText().replaceAll("\n"," vs. "));
        }
        executor.executeScript("arguments[0].click()", eventsList.get(0));

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Event Details page....");
                return driver.findElement(marketsContainer) != null;
            }
        });

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Event buttons....");
                return driver.findElements(eventBetButtons).get(0) != null;
            }
        });

        return new EventPage(driver);
    }

    /**
     * Method to select first event from given list
     * @return EventPage
     */
    public EventPage selectEvent(String firstOpponent, String secondOpponent) {
        for (int i = 0; i < eventsList.size(); i++) {
            System.out.println(eventsList.get(i).getText().replaceAll("\n"," vs. ")
                    + "\n Parameters: " +firstOpponent + " vs. " + secondOpponent);
            if(eventsList.get(i).getText().replaceAll("\n","").equals(firstOpponent + secondOpponent)) {
                System.out.println(eventsList.get(i).getText().replaceAll("\n","") + "\n opponents: " +firstOpponent + secondOpponent);
                executor.executeScript("arguments[0].click()", eventsList.get(i));
                break;
            } else if ((eventsList.get(i).getText().replaceAll("\n","")) != firstOpponent + secondOpponent && i == eventsList.size()){
                LOGGER.info("Event not found!");
            }
        }

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Event Details page....");
                return driver.findElement(marketsContainer) != null;
            }
        });

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Event buttons....");
                return driver.findElements(eventBetButtons).get(0) != null;
            }
        });

        return new EventPage(driver);
    }
}
