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

public class TXTDemo {
	static Logger log = LogManager.getLogger(TXTDemo.class.getName());

	public static void main(String[] args) {
		log.info("---------------------------------------------------------");
		Path filePath = Paths.get("sample.txt");
		String content = "This is the initial content of the file.";

//      Create File
		try {
			Files.write(filePath, Arrays.asList(content), StandardOpenOption.CREATE);
			log.info("TXT File Created Successfully.");
		} catch (IOException e) {
			log.error(e.getMessage());
		}

//      Update File
		String newContent = "This is the new content being appended to the file.";
		try {
			Files.write(filePath, Arrays.asList(newContent), StandardOpenOption.APPEND);
			log.info("Updating the TXT File Created.");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
//		Read File
		try {
    		log.info("Reading the TXT File Created.");
            List<String> lines = Files.readAllLines(filePath);
            log.info("File content:");
            for (String line : lines) {
                log.info(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
	}
}
