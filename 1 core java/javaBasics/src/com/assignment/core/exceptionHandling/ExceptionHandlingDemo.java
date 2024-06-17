package com.assignment.core.exceptionHandling;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/* 
Object
        Throwable
                Exception
                        Runtime Exceptions (Unchecked Exceptions)
                                (ArithmeticExcpetion, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException)
                        Other Exceptions (Checked Exceptions)
                                (IOException, SQLException, InterruptedException, RemoteExcpetion)
                Error
                        (VirtualMachineError, AssertionError, LinkageError)
*/

class CustomException extends Exception {
	public CustomException() { }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ParentClass {
	static Logger log = LogManager.getLogger(ParentClass.class.getName());
    public void performTaskThrows() throws IOException {
        throw new IOException("ParentClass IO Exception");
    }
    public void performTaskDoesNotThrow() {
        log.info("performTaskDoesNotThrow method called");
    }
}

class ChildClassRemoveThrows extends ParentClass {
	static Logger log = LogManager.getLogger(ChildClassRemoveThrows.class.getName());
	
    // Removing throws clause when overriding java's inherited method which has a throws clause
    @Override
    public void performTaskThrows() {
        log.info("Override method and remove throws clause");
    }
}
class ChildClassChangeThrows extends ParentClass {
    // Change throws clause (to XYZ) when overriding java's inherited method which has a throws clause (ABC)
    // IMPORTANT NOTE: XYZ must be a subclass of ABC
    @Override
    public void performTaskThrows() throws FileNotFoundException {
        throw new FileNotFoundException("performTaskThrows - FileNotFound Exception");
    }
    
    // Adding throws clause when overriding java's inherited method which does not have a throws clause
    // IMPORTANT NOTE: Can add Unchecked Exception but not Checked Exception
    @Override
    public void performTaskDoesNotThrow() throws IllegalArgumentException {
        throw new IllegalArgumentException("performTaskDoesNotThrow - IllegalArgumentException Exception");
    }
}

public class ExceptionHandlingDemo {
	static Logger log = LogManager.getLogger(ExceptionHandlingDemo.class.getName());
	
	// A method which throws IOException and SQLException
    public static void methodThatThrows() throws IOException, SQLException {
        log.info("Throw IOException");
        throw new IOException("Simulated IOException");
    }
    
    // A method which throws user-defined exception
    public static void checkValue(int value) throws CustomException {
        if (value < 10) {
            throw new CustomException("Value is less than 10");
        }
    }
    
    public static void main(String[] args) {
        // Multiple catch blocks
        try {
            log.info("Inside Try Block");
            methodThatThrows();
            log.info("Try Block Complete");
        } catch (IOException exception) {
            log.info("Inside IOException Catch Block");
            log.info("Caught an IOException: " + exception.getMessage());
            log.info("IOException Catch Block Complete");
        } catch (SQLException exception) {
            log.info("Inside SQLException Catch Block");
            log.info("Caught a SQLException: " + exception.getMessage());
            log.info("SQLException Catch Block Complete");
        } catch (Exception exception) {
            log.info("Inside Exception Catch Block");
            log.info("Caught a generic exception: " + exception.getMessage());
            log.info("Exception Catch Block Complete");
        } finally {
            log.info("Inside Finally Block");
            log.info("This is the finally block");
            log.info("Finally Block Complete\n");
        }
        
        // catch custom user defined exception
        try {
            checkValue(5);
        } catch (CustomException exception) {
            log.info("Caught custom exception: " + exception.getMessage() + "\n");
        }
        
        // one catch block to handle multiple exceptions
        try {
            int i = 5 / 0;
            // throw new ArrayIndexOutOfBoundsException("Thrown an ArrayIndexOutOfBoundsException");
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException exception) {
            log.info("Exception caught: " + exception.getMessage() + "\n");
        }
        
        ChildClassRemoveThrows child1 = new ChildClassRemoveThrows();
        // Call method overriding java's inherited method which has a throws clause. Therefore no need for try-catch block
        child1.performTaskThrows();
        child1.performTaskDoesNotThrow();
        
        log.info("");
        ChildClassChangeThrows child2 = new ChildClassChangeThrows();
        try {
        	// Call method overriding java's inherited method which has a throws clause to throw a subclass Exception
            child2.performTaskThrows();
        }
        catch (Exception exception) {
            log.info("Exception caught: " + exception.getMessage());
        }
        try {
        	// Call method overriding java's inherited method which does not have a throws clause to throw an unchecked expression
            child2.performTaskDoesNotThrow();
        }
        catch (Exception exception) {
            log.info("Exception caught: " + exception.getMessage());
        }
    }
}
