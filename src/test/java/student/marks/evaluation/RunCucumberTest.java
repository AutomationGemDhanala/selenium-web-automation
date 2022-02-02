package student.marks.evaluation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 02/01/2022
 * Last modified on : 02/01/2022
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/", glue = {"student.marks.evaluation.steps"}, tags =
    "@MarksEvaluation", plugin = {"pretty","html:target/TestResults/cucumber.html",
    "json:target/TestResults/cucumber.json"})
public class RunCucumberTest {
}
