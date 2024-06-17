package com.assignment.core.oops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Interface
interface AnimalBehavior {
	static final Logger log = LogManager.getLogger(AnimalBehavior.class.getName());
	// public static final variable
	String TYPE = "Animal";

	// public abstract methods
	void makeSound();

	void move();

	// public default method
	default void sleep() {
		log.info("The animal is sleeping");
	}
}

class Dog implements AnimalBehavior {
	static Logger log = LogManager.getLogger(Dog.class.getName());
	private String name;
	private int age;

	// Constructor
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Implementing the abstract methods
	@Override
	public void makeSound() {
		log.info("Dog barks");
	}

	@Override
	public void move() {
		log.info("Dog runs");
	}

	public void displayDetails() {
		log.info("Name: " + name);
		log.info("Age: " + age);
	}
}

class Cat implements AnimalBehavior {
	static Logger log = LogManager.getLogger(Cat.class.getName());
	private String name;
	private int age;

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public void makeSound() {
		log.info("Cat meows");
	}

	@Override
	public void move() {
		log.info("Cat prowls");
	}

	public void displayDetails() {
		log.info("Name: " + name);
		log.info("Age: " + age);
	}
}

//Main class to demonstrate the use of the interface
public class InterfaceDemo {
	static Logger log = LogManager.getLogger(InterfaceDemo.class.getName());

	public static void main(String[] args) {
		log.info("---------------------------------------------------------");
		Dog dog = new Dog("Puppy", 3);
		Cat cat = new Cat("Kitty", 2);

		log.info("Dog Details:");
		dog.displayDetails();
		dog.makeSound();
		dog.move();
		dog.sleep();

		log.info("");
		log.info("Cat Details:");
		cat.displayDetails();
		cat.makeSound();
		cat.move();
		cat.sleep();
	}
}
