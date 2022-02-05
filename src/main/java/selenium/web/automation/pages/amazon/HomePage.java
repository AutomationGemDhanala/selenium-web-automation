package selenium.web.automation.pages.amazon;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static selenium.web.automation.config.AmazonConstants.AMAZON_URL;
import static selenium.web.automation.config.AmazonConstants.AMAZON_WEBPAGE_TITLE;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAmazon() {
        driver.get(AMAZON_URL);
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(AMAZON_WEBPAGE_TITLE));
    }
}
