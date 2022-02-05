package selenium.web.automation.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selenium.web.automation.pages.amazon.HomePage;
import selenium.web.automation.pages.amazon.SearchPage;
import selenium.web.automation.pages.amazon.SearchProductDetailsPage;
import selenium.web.automation.pages.amazon.SearchResultsPage;
import selenium.web.automation.utils.SwaCsvFileUtils;
import selenium.web.automation.utils.SwaDriverUtils;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class Hooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    SearchResultsPage searchResultsPage;
    SearchProductDetailsPage searchProductDetailsPage;
    SwaCsvFileUtils swaCsvFileUtils;
    List<String[]> listOfProductDetails;

    public Hooks() {
        driver = new SwaDriverUtils().initializeChromeDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        searchProductDetailsPage = new SearchProductDetailsPage(driver);
        swaCsvFileUtils = new SwaCsvFileUtils();
        listOfProductDetails = new ArrayList<>();
        LOGGER.info("Objects initialization for all classes");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("Scenario execution started - '{}'", scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        LOGGER.info("Scenario '{}' execution finished & status : {} ", scenario.getName(),
            scenario.getStatus());
        if (driver != null) {
            driver.quit();
        }
    }
}
