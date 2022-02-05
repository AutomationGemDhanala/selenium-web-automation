package selenium.web.automation.pages.amazon;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static selenium.web.automation.utils.SwaDriverUtils.callToFluentWait;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SearchResultsPage {
    public static int whichRecordToPick;
    By searchResultsTotalByXpath = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']");
    By searchResultsSortByXpath = By.xpath("//span[@class='a-button-text a-declarative']");
    By searchResultsSortInDescById = By.id("s-result-sort-select_2");
    By searchResultsListByXpath = By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']");
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        whichRecordToPick = 0;
    }

    public void validateSearchIsSuccessful() {
        String searchResults =
            callToFluentWait(driver).until(driver -> driver.findElement(searchResultsTotalByXpath)).getText();
        Assert.assertTrue("Successful Search", searchResults.contains("results for"));
    }

    public void selectSortProductsDescOrder() {
        getSearchResultsSortByXpath().click();
        Assert.assertTrue(true);
        Actions action = new Actions(driver);
        action.moveToElement(getSearchResultsSortInDescById()).click().build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(true);
    }

    public WebElement getSearchResultsSortByXpath() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchResultsSortByXpath));
    }

    public WebElement getSearchResultsSortInDescById() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchResultsSortInDescById));
    }

    public List<String[]> navigateToProductsDetails(SearchProductDetailsPage searchProductDetailsPage,
                                                    List<String[]> listOfProductDetails, String productNameForSearch) {
        List<WebElement> resultsList = getSearchResultsListByXpath();
        for (int i = 0; i < resultsList.size(); i++) {
            try {
                if (i == whichRecordToPick) {
                    resultsList.get(whichRecordToPick).click();
                    whichRecordToPick++;
                    listOfProductDetails = searchProductDetailsPage.getProductDetails(listOfProductDetails,
                        productNameForSearch);
                }
            } catch (StaleElementReferenceException e) {
                resultsList = getSearchResultsListByXpath();
                i--;
            }
        }
        return listOfProductDetails;
    }

    public List<WebElement> getSearchResultsListByXpath() {
        return callToFluentWait(driver).until(driver -> driver.findElements(searchResultsListByXpath));
    }
}
