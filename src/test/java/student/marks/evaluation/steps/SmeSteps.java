package student.marks.evaluation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/1/22, 5:55 PM
 * Last modified on : 2/1/22, 5:55 PM
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SmeSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmeSteps.class);
    Hooks hooks;

    @Given("Assume we have list of students data in {string} file")
    public void assumeWeHaveListOfStudentsDataInFile(String arg0) {
        hooks = new Hooks();
        LOGGER.info("Initialized the objects in Given");
    }

    @When("Generate {string} students data in {string} for average calculation")
    public void generateStudentsDataInForAverageCalculation(String arg0, String arg1) {
        Hooks.smeCsvFileUtils.generateInitialSmeDataIntoCsvFile(arg1, Integer.parseInt(arg0));
        LOGGER.info("Data is generated in When");
    }

    @Then("Validate average calculated and stored in {string} file")
    public void validateAverageCalculatedAndStoredInFile(String arg0) {
        boolean statusOfScenario = Hooks.smeCsvFileUtils.calculateAverageOfStudentMarksAndSaveIntoCsvFile(arg0);
        LOGGER.info("Data is validation after creation in Then");
        Assert.assertTrue("Finally we have valid data for Student Mark Evaluation", statusOfScenario);
    }

}
