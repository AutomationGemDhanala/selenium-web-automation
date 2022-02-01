package student.marks.evaluation;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Random;

/*******************************************************************************
 * Copyright (c) 2022 This project is belongs to 'Venkateswarlu Dhanala'
 * Created on : 02/01/2022
 * Last modified on : 02/01/2022
 * Owned by : Venkateswarlu Dhanala
 ******************************************************************************/

public class SmeFileUtils {
    private static final Logger LOGGER = Logger.getLogger(SmeFileUtils.class);
    FileWriter fileWriter;
    CSVWriter csvWriter;
    CSVReader csvReader;


    public void generateInitialSmeDataIntoCsvFile(String initialStudentMarksData){
        File newSmeDataCsvFile = new File(initialStudentMarksData);
        try{
            newSmeDataCsvFile.createNewFile();
            fileWriter = new FileWriter(newSmeDataCsvFile);
            csvWriter = new CSVWriter(fileWriter);
            String[] dataHeaders = {"Firstname","Lastname","Subject1","Subject2","Subject3","Subject4","Subject5"};
            csvWriter.writeNext(dataHeaders);
            ;
            for (int i=1; i <2000; i++) {
                String[] studentDetails = {generateRandomFnLn(), generateRandomFnLn(), generateRandomSubjectMarks(), generateRandomSubjectMarks(), generateRandomSubjectMarks(), generateRandomSubjectMarks(), generateRandomSubjectMarks()};
                csvWriter.writeNext(studentDetails);
            }
            fileWriter.close();
        }catch (Exception e) {
            LOGGER.error("Error while creating student data initially" + e.getMessage());
        }
    }

    public String generateRandomFnLn(){
        //  making sure FirstName/LastName below 25 characters
        return RandomStringUtils.randomAlphabetic(new Random().nextInt(25));
    }

    public String generateRandomSubjectMarks(){
        //  making sure subject marks <= 100 &
        //  converting to String for csv storage purpose
        return String.valueOf(new Random().nextInt(100));
    }

    public void calculateAverageOfStudentMarksAndSaveIntoCsvFile(String initialStudentMarksData){
        File newSmeDataCsvFile = new File(initialStudentMarksData);
        try{
            newSmeDataCsvFile.createNewFile();
            fileWriter = new FileWriter(newSmeDataCsvFile);
            csvWriter = new CSVWriter(fileWriter);
            String[] dataHeaders = {"Firstname","Lastname","Subject1","Subject2","Subject3","Subject4","Subject5"};
            csvWriter.writeNext(dataHeaders);
            ;
            for (int i=1; i <2000; i++) {
                String[] studentDetails = {generateRandomFnLn(), generateRandomFnLn(), generateRandomSubjectMarks(), generateRandomSubjectMarks(), generateRandomSubjectMarks(), generateRandomSubjectMarks(), generateRandomSubjectMarks()};
                csvWriter.writeNext(studentDetails);
            }
            fileWriter.close();
        }catch (Exception e) {
            LOGGER.error("Error while creating student data initially" + e.getMessage());
        }
    }


}
