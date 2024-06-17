package com.assignment.core.basics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoopsDecisionMaking {
	static Logger log = LogManager.getLogger(LoopsDecisionMaking.class.getName());

    public static void main(String[] args) {
        log.info("---------------------------------------------------------");
        log.info("If statement");
        if (true) {
            log.info("Inside If\n");
        }
        
        log.info("If-else statement");
        if (11 % 2 == 0) {
            log.info("Even number\n");
        }
        else {
            log.info("Odd number\n");
        }
        
        log.info("If-else-if statement");
        if (9 % 2 == 0) {
            log.info("Divisible by 2\n");
        }
        else if (9 % 3 == 0) {
            log.info("Divisible by 3\n");
        }
        else {
            log.info("Not Divisible by 2 or 3\n");
        }
        
        log.info("Nested-if statement");
        if (12 % 2 == 0) {
        	if (12 % 3 == 0) {
        		log.info("Divisible by 6\n");
        	} else {
        		log.info("Divisible by 2\n");
        	}
        }
        else {
        	if (12 % 3 == 0) {
        		log.info("Divisible by 3\n");
        	} else {
        		log.info("Divisible by neither 2, 3 or 6\n");
        	}
        }
        
        log.info("Switch statement");
        switch (5) {
            case 0: log.info("Sunday\n");
                break;
            case 1: log.info("Monday\n");
                break;
            case 2: log.info("Tuesday\n");
                break;
            case 3: log.info("Wednesday\n");
                break;
            case 4: log.info("Thursday\n");
                break;
            case 5: log.info("Friday\n");
                break;
            case 6: log.info("Saturday\n");
                break;
            default: log.info("Invalid entry\n");
        }
        
        log.info("continue statement, for loop");
        for (int i = 0 ; i < 10 ; i++) {
            if (i % 3 == 0) 
                continue;
            log.info(i);
        }
        
        log.info("\n");        
        log.info("break statement, while loop");
        int i = 0;
        while (i <= 10) {
            if (i == 4) 
                break;
            log.info(i++);
        }
        
        log.info("\n");        
        log.info("do while loop");
        i = 0;
        do {
            log.info(i++);
        } while (i < 0);
        
        log.info("\n");        
        log.info("Before return statement");
        if (true) 
            return;
        log.info("After return statement");
    }
}