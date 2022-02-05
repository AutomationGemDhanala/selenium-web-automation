package selenium.web.automation.pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static selenium.web.automation.utils.SwaDriverUtils.callToFluentWait;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SearchPage {
    By searchTextBoxById = By.id("twotabsearchtextbox");
    By searchSubmitButtonById = By.id("nav-search-submit-button");
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTextInSearchBox(String productSearch) {
        getSearchTextBox().sendKeys(productSearch);
    }

    public WebElement getSearchTextBox() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchTextBoxById));
    }

    public void clickOnSearchSubmitButton() {
        getSearchSubmitButton().click();
    }

    public WebElement getSearchSubmitButton() {
        return callToFluentWait(driver).until(driver -> driver.findElement(searchSubmitButtonById));
    }

}
