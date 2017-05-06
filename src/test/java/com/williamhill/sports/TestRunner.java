package com.williamhill.sports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Marek on 5/5/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"pretty" ,"html:reports" ,
                "json:reports/cucumber.json" ,
                "junit:reports/cucumber.xml"}
)
public class TestRunner {
}
