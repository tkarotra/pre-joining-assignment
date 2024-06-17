package com.assignment.core.basics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JavaDatatypes {
	static Logger log = LogManager.getLogger(JavaDatatypes.class.getName());
	
	public static void main(String[] args) {
		// Primitive data types
        byte byteVariable = 10; // 8-bit integer
        short shortVariable = 100; // 16-bit integer
        int intVariable = 1000; // 32-bit integer
        long longVariable = 10000L; // 64-bit integer
        float floatVariable = 10.5f; // 32-bit floating point
        double doubleVariable = 100.5; // 64-bit floating point
        boolean booleanVariable = false; // true or false 
        char charVariable = 'A'; // 16-bit Unicode character

        log.info("---------------------------------------------------------");
        log.info("Primitive Data Types:");
        log.info("byte Datatype: " + byteVariable);
        log.info("short Datatype: " + shortVariable);
        log.info("int Datatype: " + intVariable);
        log.info("long Datatype: " + longVariable);
        log.info("float Datatype: " + floatVariable);
        log.info("double Datatype: " + doubleVariable);
        log.info("boolean Datatype: " + booleanVariable);
        log.info("char Datatype: " + charVariable + "\n");

        // Non-primitive data types
        String stringVariable = "This is an object of string class!"; // String object
        // User-defined class
        Person person = new Person("Teesha", 22);

        log.info("Non-primitive Data Types:");
        log.info("String Class: " + stringVariable);
        log.info("User-defined Class (Person): " + person);
        log.info("User-defined Class (Name Variable): " + person.name);
        log.info("User-defined Class (Age Variable): " + person.age);
	}
}