package com.williamhill.sports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Marek on 5/3/2017.
 * Class represents Home Page
 */
public class HomePage extends BetEventPage {
    public final static Logger LOGGER= LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
       super(driver);
    }

    /* Page objects */
    private By highlightsSection = By.cssSelector("section[id^='match-highlights");
    private By eventLinks = By.cssSelector(".btmarket__link-name");

    /**
     * Method for selecting type of event f.e. football
     * @param eventType
     * @return
     */
    public EventsPage selectEventType(String eventType) {
        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Home Page....");
                return driver.findElement(By.id("nav-" + eventType + "")) != null;
            }
        });

        driver.findElement(By.id("nav-" + eventType + "")).click();

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Events Page....");
                return driver.findElement(highlightsSection) != null;
            }
        });

        SeleniumUtils.defaultWait(driver).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                LOGGER.info("Waiting for Events list....");
                return driver.findElements(eventLinks).get(0) != null;
            }
        });

        return new EventsPage(driver);
    }
}
