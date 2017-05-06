package com.williamhill.sports;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Marek on 5/5/2017.
 */
public class SeleniumUtils {

    private SeleniumUtils() {
    }

    /**
     * Default Wait
     * @param driver
     * @return wait
     */
    public static Wait defaultWait(WebDriver driver) {
        Wait wait = new FluentWait(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(1, SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(IndexOutOfBoundsException.class);

        return wait;
    }
}
