package selenium.web.automation.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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

public class AmazonProductSearchTest {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    SearchResultsPage searchResultsPage;
    SearchProductDetailsPage searchProductDetailsPage;
    SwaCsvFileUtils swaCsvFileUtils;
    List<String[]> listOfProductDetails;

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() {
        driver = new SwaDriverUtils().initializeChromeDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        searchProductDetailsPage = new SearchProductDetailsPage(driver);
        swaCsvFileUtils = new SwaCsvFileUtils();
        listOfProductDetails = new ArrayList<>();
    }

    @Test(enabled = false)
    public void validateAmazonWebPageLaunch() {
        homePage.navigateToAmazon();
    }

    @Test(dataProvider = "bluetooth", dataProviderClass = AmazonDataProvider.class)
    public void validateAmazonProductSearchBluetooth(String scenarioNumber, String productNameForSearch) {
        homePage.navigateToAmazon();
        searchPage.enterTextInSearchBox(productNameForSearch);
        searchPage.clickOnSearchSubmitButton();
        searchResultsPage.validateSearchIsSuccessful();
        searchResultsPage.selectSortProductsDescOrder();
        listOfProductDetails = searchResultsPage.navigateToProductsDetails(searchProductDetailsPage,
            listOfProductDetails, productNameForSearch);
        String stringCsvFileName = "src/main/resources/testng/" + scenarioNumber + ".csv";
        swaCsvFileUtils.saveProductSearchDetailsIntoCsvFile(stringCsvFileName,
            listOfProductDetails);
        swaCsvFileUtils.sortTopTwoProductsByCostIntoCsvFile(stringCsvFileName);
    }

    @Test(dataProvider = "led", dataProviderClass = AmazonDataProvider.class)
    public void validateAmazonProductSearchLed(String scenarioNumber, String productNameForSearch) {
        homePage.navigateToAmazon();
        searchPage.enterTextInSearchBox(productNameForSearch);
        searchPage.clickOnSearchSubmitButton();
        searchResultsPage.validateSearchIsSuccessful();
        searchResultsPage.selectSortProductsDescOrder();
        listOfProductDetails = searchResultsPage.navigateToProductsDetails(searchProductDetailsPage,
            listOfProductDetails, productNameForSearch);
        String stringCsvFileName = "src/main/resources/testng/" + scenarioNumber + ".csv";
        swaCsvFileUtils.saveProductSearchDetailsIntoCsvFile(stringCsvFileName,
            listOfProductDetails);
        swaCsvFileUtils.sortTopTwoProductsByCostIntoCsvFile(stringCsvFileName);
    }

    @Test(dataProvider = "usb", dataProviderClass = AmazonDataProvider.class)
    public void validateAmazonProductSearchUsb(String scenarioNumber, String productNameForSearch) {
        homePage.navigateToAmazon();
        searchPage.enterTextInSearchBox(productNameForSearch);
        searchPage.clickOnSearchSubmitButton();
        searchResultsPage.validateSearchIsSuccessful();
        searchResultsPage.selectSortProductsDescOrder();
        listOfProductDetails = searchResultsPage.navigateToProductsDetails(searchProductDetailsPage,
            listOfProductDetails, productNameForSearch);
        String stringCsvFileName = "src/main/resources/testng/" + scenarioNumber + ".csv";
        swaCsvFileUtils.saveProductSearchDetailsIntoCsvFile(stringCsvFileName,
            listOfProductDetails);
        swaCsvFileUtils.sortTopTwoProductsByCostIntoCsvFile(stringCsvFileName);
    }

    @Test(dataProvider = "watch", dataProviderClass = AmazonDataProvider.class)
    public void validateAmazonProductSearchWatch(String scenarioNumber, String productNameForSearch) {
        homePage.navigateToAmazon();
        searchPage.enterTextInSearchBox(productNameForSearch);
        searchPage.clickOnSearchSubmitButton();
        searchResultsPage.validateSearchIsSuccessful();
        searchResultsPage.selectSortProductsDescOrder();
        listOfProductDetails = searchResultsPage.navigateToProductsDetails(searchProductDetailsPage,
            listOfProductDetails, productNameForSearch);
        String stringCsvFileName = "src/main/resources/testng/" + scenarioNumber + ".csv";
        swaCsvFileUtils.saveProductSearchDetailsIntoCsvFile(stringCsvFileName,
            listOfProductDetails);
        swaCsvFileUtils.sortTopTwoProductsByCostIntoCsvFile(stringCsvFileName);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        tearDown();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
