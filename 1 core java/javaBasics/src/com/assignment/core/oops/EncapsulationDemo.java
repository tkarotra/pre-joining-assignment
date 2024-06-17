package com.assignment.core.oops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class AnimalED {
	private String name, species;
	private boolean isVegetarian;
	private int noOfLegs;

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setIsVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public boolean getIsVegetarian() {
		return isVegetarian;
	}

	public int getNoOfLegs() {
		return noOfLegs;
	}
}

public class EncapsulationDemo {
	static Logger log = LogManager.getLogger(EncapsulationDemo.class.getName());

	public static void main(String[] args) {
		AnimalED animal;
		animal = new AnimalED();
		animal.setName("Labrador");
		animal.setSpecies("Dog");
		animal.setIsVegetarian(true);
		animal.setNoOfLegs(4);

		log.info("---------------------------------------------------------");
		log.info("Details: Name = " + animal.getName() + ", Species = " + animal.getSpecies() + ", Is Vegetarian = "
				+ animal.getIsVegetarian() + ", No. of Legs = " + animal.getNoOfLegs());
	}
}