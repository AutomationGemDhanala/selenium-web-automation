package selenium.web.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SwaDriverUtils {
    WebDriver driver;

    public static Wait<WebDriver> callToFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30L))
            .pollingEvery(Duration.ofSeconds(5L))
            .ignoring(NoSuchElementException.class);
    }

    public WebDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        return driver = new ChromeDriver();
    }
}
