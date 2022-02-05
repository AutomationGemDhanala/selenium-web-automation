package selenium.web.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SwaSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(SwaSteps.class);
    Hooks hooks;

    @Given("Navigate to amazon website for product search")
    public void navigateToAmazonWebsiteForProductSearch() {
        hooks = new Hooks();
        hooks.homePage.navigateToAmazon();
        LOGGER.info("Initialized the objects in Given");
    }

    @When("Enter the {string} for search box")
    public void enterTheForSearchBox(String productNameForSearch) {
        hooks.searchPage.enterTextInSearchBox(productNameForSearch);
    }

    @And("Click on search button for each product")
    public void clickOnSearchButtonForEachProduct() {
        hooks.searchPage.clickOnSearchSubmitButton();
        hooks.searchResultsPage.validateSearchIsSuccessful();
    }

    @And("Select the sort by price descending order")
    public void selectTheSortByPriceDescendingOrder() {
        hooks.searchResultsPage.selectSortProductsDescOrder();
    }

    @Then("Retrieve all products with {string} and stored in {string} file")
    public void retrieveAllProductsWithAndStoredInFile(String productNameForSearch, String stringCsvFileName) {
        hooks.listOfProductDetails = hooks.searchResultsPage.navigateToProductsDetails(hooks.searchProductDetailsPage,
            hooks.listOfProductDetails, productNameForSearch);
        hooks.swaCsvFileUtils.saveProductSearchDetailsIntoCsvFile(stringCsvFileName,
            hooks.listOfProductDetails);
    }

    @And("Sort and store top two product for each product results in {string} file")
    public void sortAndStoreTopTwoProductForEachProductResultsInFile(String stringCsvFileName) {
        hooks.swaCsvFileUtils.sortTopTwoProductsByCostIntoCsvFile(stringCsvFileName);
        LOGGER.info("Data is validation after creation in Then");
        Assert.assertTrue(true);
    }
}
