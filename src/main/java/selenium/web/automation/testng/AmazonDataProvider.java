package selenium.web.automation.testng;

import org.testng.annotations.DataProvider;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class AmazonDataProvider {
    @DataProvider(name = "bluetooth")
    public static Object[][] dataProviderProductNamesListBluetooth() {
        return new Object[][]{
            {"SC1", "Bluetooth headset"}
        };
    }

    @DataProvider(name = "led")
    public static Object[][] dataProviderProductNamesListLed() {
        return new Object[][]{
            {"SC2", "34 inch LED monitor"}
        };
    }

    @DataProvider(name = "usb")
    public static Object[][] dataProviderProductNamesListUsb() {
        return new Object[][]{
            {"SC3", "USB c dock"}
        };
    }

    @DataProvider(name = "watch")
    public static Object[][] dataProviderProductNamesListWatch() {
        return new Object[][]{
            {"SC4", "Smart watch"}
        };
    }
}
