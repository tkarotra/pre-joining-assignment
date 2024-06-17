package com.assignment.core.basics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JavaBasics {
	// Variables used to show state of an object
	String name;
	int age;
	static Logger log = LogManager.getLogger(JavaBasics.class.getName());

	// Constructor
	public JavaBasics(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Methods used to display behavior of the object
	public void greet() {
		log.info("Hello, my name is " + name + " and I am " + age + " years old.");
	}

	public void updateName(String newName) {
		name = newName;
		log.info("Name has been changed to " + name + ".");
	}

	public static void main(String[] args) {
		// Creating object of JavaBasics class (new keyword followed by call to constructor)
		JavaBasics person1 = new JavaBasics("Teesha", 22);

		// Calling methods of the objects
		person1.greet();
		person1.updateName("Vidhi");
		person1.greet();

	}
}
