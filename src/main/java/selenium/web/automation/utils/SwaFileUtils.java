package selenium.web.automation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 2/3/22
 * Last modified on : 2/4/22
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SwaFileUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(SwaFileUtils.class);
    Properties properties;

    public SwaFileUtils(String filePath) {
        try {
            FileInputStream Locator = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(Locator);
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found Exception was thrown - {}", e.getMessage());
        } catch (IOException e) {
            LOGGER.error("IO Exception was thrown - {}", e.getMessage());
        }
    }

    public String getData(String elementName) {
        return properties.getProperty(elementName);
    }
}
