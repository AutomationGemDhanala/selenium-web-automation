package selenium.web.automation.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 02/03/2022
 * Last modified on : 02/04/2022
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SwaCsvFileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SwaCsvFileUtils.class);
    FileWriter fileWriter;
    CSVWriter csvWriter;

    public SwaCsvFileUtils() {
    }

    public void saveProductSearchDetailsIntoCsvFile(String filePathToStoreProductDetails,
                                                    List<String[]> listOfProductDetails) {
        File newSwaDataCsvFile = new File(filePathToStoreProductDetails);
        try {
            fileWriter = new FileWriter(newSwaDataCsvFile);
            csvWriter = new CSVWriter(fileWriter);
            String[] dataHeaders =
                {"Name", "Description", "Rating", "Cost"};
            csvWriter.writeNext(dataHeaders);
            for (String[] singleRecord : listOfProductDetails) {
                String[] productDetails = {singleRecord[0], singleRecord[1], singleRecord[2], singleRecord[3]};
                csvWriter.writeNext(productDetails);
            }
            csvWriter.close();
        } catch (Exception e) {
            LOGGER.error("Error message thrown during data storage");
        }
    }

    public void sortTopTwoProductsByCostIntoCsvFile(String filePathToStoreProductDetails) {
        try {
            FileReader fileReader = new FileReader(filePathToStoreProductDetails);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;
            // storing each line/record into string for writing back to csv file
            List<String> dataWithTopTwoProductsDetails = new ArrayList<>();
            List<String[]> tempDataWithTopTwoProductsDetails = new ArrayList<>();

            boolean isHeader = true;
            // reading each record from existing csv file
            List<Double> list = new ArrayList<>();
            while ((nextRecord = csvReader.readNext()) != null) {
                // if first record & header is true, skip it
                if (isHeader) {
                    tempDataWithTopTwoProductsDetails.add(nextRecord);
                    isHeader = false;
                } else {
                    // rest all records [we have cost details in column 4]
                    String productCostAsString = nextRecord[3];
                    if (!productCostAsString.equalsIgnoreCase("cost not available")) {
                        list.add(Double.parseDouble(productCostAsString.replace("$", "")));
                        tempDataWithTopTwoProductsDetails.add(nextRecord);
                    }
                }
            }

            // sorting the cost details
            list.sort(Collections.reverseOrder());
            isHeader = true;
            for (int i = 0; i < 2; i++) {
                String costValue = "$" + list.get(i);
                // reading each record from existing csv file
                for (String[] tempDataProduct : tempDataWithTopTwoProductsDetails) {
                    // if first record & header is true, skip it
                    if (isHeader) {
                        dataWithTopTwoProductsDetails.add(Arrays.toString(tempDataProduct)
                            .replace("[", "")
                            .replace("]", ""));
                        isHeader = false;
                    } else {
                        // rest all records checking for teh value
                        if (Arrays.toString(tempDataProduct).contains(costValue)) {
                            dataWithTopTwoProductsDetails.add(Arrays.toString(tempDataProduct)
                                .replace("[", "")
                                .replace("]", ""));
                            break;
                        }
                    }
                }
            }

            File newTopTwoProductDataCsvFile = new File(filePathToStoreProductDetails);
            fileWriter = new FileWriter(newTopTwoProductDataCsvFile);
            csvWriter = new CSVWriter(fileWriter);
            for (String eachLineWrite : dataWithTopTwoProductsDetails) {
                csvWriter.writeNext(eachLineWrite.split(","));
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
