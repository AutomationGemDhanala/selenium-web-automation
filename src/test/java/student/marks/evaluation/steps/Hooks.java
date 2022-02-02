package student.marks.evaluation.steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import student.marks.evaluation.SmeCsvFileUtils;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/1/22
 * Last modified on : 2/1/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class Hooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
    public static SmeCsvFileUtils smeCsvFileUtils;

    public Hooks() {
        smeCsvFileUtils = new SmeCsvFileUtils();
        LOGGER.info("Object is created for SmeCevFileUtils class");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("Scenario execution started - '{}'", scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        LOGGER.info("Scenario '{}' execution finished & status : {} ", scenario.getName(),
            scenario.getStatus());
    }
}
