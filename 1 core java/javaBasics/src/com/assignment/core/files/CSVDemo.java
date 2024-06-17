package com.assignment.core.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CSVDemo {
	static Logger log = LogManager.getLogger(CSVDemo.class.getName());

	public static void main(String[] args) {
		Path filePath = Paths.get("country-languages.csv");

//      Create File
        List<String> initialLines = Arrays.asList(
            "CountryCode, Language, IsOfficial, Percentage",
            "USA, English, T, 80.0",
            "USA, Spanish, F, 15.0"
        );
        try {
            Files.write(filePath, initialLines, StandardOpenOption.CREATE);
			log.info("CSV File Created Successfully.");
        } catch (IOException e) {
        	log.error(e.getMessage());
        }

//      Update File
        List<String> newLines = Arrays.asList(
            "USA, French, F, 4.0",
            "CAN, English, T, 70.0",
            "CAN, French, T, 20.0"
        );
        try {
            Files.write(filePath, newLines, StandardOpenOption.APPEND);
			log.info("Updating the CSV File Created.");
        } catch (IOException e) {
        	log.error(e.getMessage());
        }

//      Read File
        try {
            List<String> lines = Files.readAllLines(filePath);
			log.info("Reading the CSV File Created.");
            for (String line : lines) {
                log.info(line);
            }
        } catch (IOException e) {
        	log.error(e.getMessage());
        }
	}
}
