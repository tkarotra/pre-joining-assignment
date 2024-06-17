package com.assignment.core.basics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Variable Types - Instance Variable (name and age)
                 Class Variable (otherName)
                 Local Variable (greeting, scientificName, Human1, Human2)
                 
Modifier Types - Access Modifiers
                        - public
                        - protected *
                        - private *
                        - default (when none of the above 3 are used)
               - Non-access Modifiers
                        - final
                        - static *
                        - abstract
               (* indicates that the modifier cannot be used for classes)
*/

class Human {
	// Instance Variables
	private String name;
	int age;

	// Class Variable (Static Variables)
	public static String otherName = "Human";
	static Logger log = LogManager.getLogger(Human.class.getName());

	// Non-parameterized constructor (Given by default by java if you haven't given a
	// parameterized constructor else not given)
	public Human() {

	}

	// Parameterized Constructor
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Instance Methods
	public void introduce() {
		// Local variable
		String greeting = "Hello, my name is " + name + " and I am " + age + " years old. My scientific name is "
				+ SCIENTIFIC_NAME;
		log.info(greeting);
	}

	// Class Method (can't access instance variables. can access class variables)
	public static String getOtherName() {
		return otherName;
	}

	protected void updateName(String name) {
		this.name = name;
	}

	private void updateAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// Final variable - once initialized can't be changed
	public static final String SCIENTIFIC_NAME = "Homo sapiens";
}

public class VariablesModifiers {
	static Logger log = LogManager.getLogger(VariablesModifiers.class.getName());

	public static void main(String[] args) {
        log.info("---------------------------------------------------------");
        
		// Local variable
		String otherName;

		// Calling the class method
		otherName = Human.getOtherName();
		log.info("Other Name of Humans is : " + otherName);

		// Updating the value of class variable otherName
		// Can't update the value of SCIENTIFIC_NAME
		Human.otherName = "Hominid";
		otherName = Human.getOtherName();
		log.info("Updated Other Name of Humans is : " + otherName);
		log.info("Scientific Name of Humans is : " + Human.SCIENTIFIC_NAME);

		// Creating objects of HelloWorld class
		Human Human1 = new Human("Teesha", 22);
		Human Human2 = new Human("Vidhi", 18);

		// Calling instance methods of the objects
		Human1.introduce();
		Human2.introduce();

		// Can access age variable but can't access name variable
		Human1.age = 20;

		// Can access updateName method but can't access updateAge method
		Human2.updateName("Vidhi Karotra");

		Human1.introduce();
		Human2.introduce();
	}
}
