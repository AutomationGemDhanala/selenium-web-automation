package selenium.web.automation.pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static selenium.web.automation.utils.SwaDriverUtils.callToFluentWait;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SearchProductDetailsPage {
    WebDriver driver;
    By searchProductNameById = By.id("productTitle");
    By searchProductRatingByXpath = By.xpath("//span[@id='acrPopover']");
    By searchProductCostByXpath = By.xpath(".//span[@class='a-price aok-align-center priceToPay']");
    By searchProductCostOptionalById = By.id("aod-price-1");
    By searchProductCostOptionalCloseByXpath = By.xpath(
        "//i[@class='a-icon a-icon-close a-icon-medium aod-close-button']");
    By searchProductUnavailabilityById = By.id("availability");
    By searchProductSeeAllBuyingOptionsById = By.id("buybox-see-all-buying-choices");
    By searchBackToResultsById = By.id("breadcrumb-back-link");

    public SearchProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String[]> getProductDetails(List<String[]> listOfProductDetails, String productNameForSearch) {
        String productName = getSearchProductNameById().getText().replace(",", ";");
        String productRating = getProductRating();
        String productCost = getProductCost().replace("\n", ".").replace(",", "");
        String[] productDetails = {productNameForSearch, productName, productRating, productCost};
        listOfProductDetails.add(productDetails);
        getSearchBackToResultsById().click();
        return listOfProductDetails;
    }

    public WebElement getSearchProductNameById() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchProductNameById));
    }

    public String getProductRating() {
        try {
            return getSearchProductRatingByXpath().getAttribute("title");
        } catch (Exception e) {
            try {
                if (getSearchProductUnavailabilityById().getText().equalsIgnoreCase("Currently unavailable."))
                    return "currently unavailable";
                return "rating not available";
            } catch (Exception ex) {
                return "rating not available";
            }
        }
    }

    public String getProductCost() {
        try {
            return getSearchProductCostByXpath().getText();
        } catch (Exception ex) {
            try {
                String unavailableStr = getSearchProductUnavailabilityById().getText();
                if (unavailableStr.equalsIgnoreCase("Currently unavailable."))
                    return "currently unavailable";
            } catch (Exception exp) {
                return "cost not available";
            }
            return "cost not available";
        }
    }

    public WebElement getSearchBackToResultsById() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchBackToResultsById));
    }

    public WebElement getSearchProductRatingByXpath() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchProductRatingByXpath));
    }

    public WebElement getSearchProductUnavailabilityById() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchProductUnavailabilityById));
    }

    public WebElement getSearchProductCostByXpath() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchProductCostByXpath));
    }

    public String getProductCostModify() {
        try {
            return getSearchProductCostByXpath().getText();
        } catch (Exception e) {
            try {
                String seeAllBuyingStr = getSearchProductSeeAllBuyingOptionsById().getText();
                if (seeAllBuyingStr.equalsIgnoreCase("See All Buying Options")) {
                    getSearchProductSeeAllBuyingOptionsById().click();
                    String additionalWayForCost = getSearchProductCostOptionalById().getText();
                    getSearchProductCostOptionalCloseByXpath().click();
                    return additionalWayForCost;
                }
            } catch (Exception ex) {
                try {
                    String unavailableStr = getSearchProductUnavailabilityById().getText();
                    if (unavailableStr.equalsIgnoreCase("Currently unavailable."))
                        return "currently unavailable";
                } catch (Exception exp) {
                    return "cost not available";
                }
                return "cost not available";
            }
            return "cost not available";
        }
    }

    public WebElement getSearchProductSeeAllBuyingOptionsById() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchProductSeeAllBuyingOptionsById));
    }

    public WebElement getSearchProductCostOptionalById() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchProductCostOptionalById));
    }

    public WebElement getSearchProductCostOptionalCloseByXpath() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(searchProductCostOptionalCloseByXpath));
    }

}
