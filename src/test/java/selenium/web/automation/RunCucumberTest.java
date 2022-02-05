package selenium.web.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", glue = {"selenium.web.automation.steps"}, tags =
    "@AmazonProductSearch", plugin = {"pretty", "html:target/TestResults/cucumber.html",
    "json:target/TestResults/cucumber.json"})
public class RunCucumberTest {
}
