package com.assignment.core.oops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Abstract class
abstract class AnimalAD {
	static Logger log = LogManager.getLogger(AnimalAD.class.getName());
	private String name;
	private int age;

	public AnimalAD(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void displayDetails() {
		log.info("Name: " + name);
		log.info("Age: " + age);
	}

	// Abstract methods
	public abstract void makeSound();

	public abstract void move();
}

class DogAD extends AnimalAD {
	static Logger log = LogManager.getLogger(DogAD.class.getName());
	public DogAD(String name, int age) {
		super(name, age);
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
}

class CatAD extends AnimalAD {
	static Logger log = LogManager.getLogger(CatAD.class.getName());
	public CatAD(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeSound() {
		log.info("Cat meows");
	}

	@Override
	public void move() {
		log.info("Cat prowls");
	}
}

public class AbstractionDemo {
	static Logger log = LogManager.getLogger(AbstractionDemo.class.getName());
	
	public static void main(String[] args) {
        log.info("---------------------------------------------------------");
		AnimalAD dog = new DogAD("Puppy", 3);
		log.info("Dog Details:");
		dog.displayDetails();
		dog.makeSound();
		dog.move();

		AnimalAD cat = new CatAD("Kitty", 2);
		log.info("");
		log.info("Cat Details:");
		cat.displayDetails();
		cat.makeSound();
		cat.move();
	}
}