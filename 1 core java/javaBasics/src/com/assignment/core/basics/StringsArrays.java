package com.assignment.core.basics;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringsArrays {
	static Logger log = LogManager.getLogger(StringsArrays.class.getName());
	
    public static void main(String[] args) {
        log.info("---------------------------------------------------------");
        log.info("------------- STRINGS -------------");
        char[] nameArray = { 't', 'e', 'e', 's', 'h', 'a' };
        String nameString = new String(nameArray);
        log.info("Name String: " + nameString);
        nameString = nameString.concat(" Karotra");
        log.info("Concatenated String: " + nameString);
        log.info("Length of String: " + nameString.length());
        log.info("Upper Case String: " + nameString.toUpperCase());
        log.info("Lower Case String: " + nameString.toLowerCase());
        log.info("Char at 4th Index in String: " + nameString.charAt(4));
        log.info("Contains String: " + nameString.contains("tee"));
        log.info("Substring of String: " + nameString.substring(3, 6));
        log.info("First Occurence of String: " + nameString.indexOf("a"));
        log.info("Last Occurence of String: " + nameString.lastIndexOf("a"));
        log.info("First Occurence of String (from 6th index): " + nameString.indexOf("a", 6));
        log.info("String After Replacing 'a' with 'k': " + nameString.replace("a", "k"));
        log.info("equals Method: " + nameString.equals("Teesha Karotra"));
        log.info("equalsIgnoreCase Method: " + nameString.equalsIgnoreCase("Teesha Karotra"));
        log.info("startsWith Method: " + nameString.startsWith("tee"));
        log.info("endsWith Method: " + nameString.endsWith("Tee") + "\n");
        
        
        
        log.info("------------- ARRAYS -------------");
        int[] integerArray = new int[]{4, 1, 3, 2, 5};
        log.info("Array Elements: " + Arrays.toString(integerArray));
        log.info("Array Length: " + integerArray.length);
        Arrays.sort(integerArray, 2, 5);
        log.info("Sorted Array (2nd to 5th Index) Elements: " + Arrays.toString(integerArray));
        Arrays.sort(integerArray);
        log.info("Sorted Array Elements: " + Arrays.toString(integerArray));
        
        int[] integerArray2;
        integerArray2 = new int[5];
        for (int element: integerArray) {
            integerArray2[element - 1] = element + 2;
        }
        log.info("New Array: " + Arrays.toString(integerArray2) + "\n");
        
        short[][] multiDimensionalArray = new short[][] {
            {2, 4, 6, 8},
            {3, 6, 9, 12},
            {4, 8, 12, 16},
        };
        log.info("Multi Dimensional Array: [");
        for (short[] innerArray: multiDimensionalArray) {
            log.info("\t" + Arrays.toString(innerArray));
        }
        log.info("]");
    }
}