package com.assignment.core.oops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Base class
class Employee {
	static Logger log = LogManager.getLogger(Employee.class.getName());
	private String name;
	private int employeeId;
	private double salary;

	public Employee() {
	}

	public Employee(String name, int employeeId, double salary) {
		this.name = name;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	public void displayDetails() {
		log.info("Name: " + name);
		log.info("Employee ID: " + employeeId);
		log.info("Salary: " + salary);
	}

	public double getSalary() {
		return salary;
	}
}

//Derived Class (from Employee Base Class)
class Accountant extends Employee {
	static Logger log = LogManager.getLogger(Accountant.class.getName());
	private String certification;

	public Accountant() {
	}

	public Accountant(String name, int employeeId, double salary, String certification) {
		super(name, employeeId, salary);
		this.certification = certification;
	}

//Overriding method
	@Override
	public void displayDetails() {
		super.displayDetails();
		log.info("Certification: " + certification);
	}
}

//Derived Class (from Employee Base Class)
class Engineer extends Employee {
	static Logger log = LogManager.getLogger(Engineer.class.getName());
	private String specialty;

	public Engineer() {
	}

	public Engineer(String name, int employeeId, double salary, String specialty) {
		super(name, employeeId, salary);
		this.specialty = specialty;
	}

//Overriding method
	@Override
	public void displayDetails() {
		super.displayDetails();
		log.info("Specialty: " + specialty);
	}

	public String getSpecialty() {
		log.info("");
		log.info("'displaySpecialty' method inside 'Engineer' class called");
		return specialty;
	}
}

//Derived Class (from Engineer Base Class)
class SoftwareDevelopmentEngineer extends Engineer {
	static Logger log = LogManager.getLogger(SoftwareDevelopmentEngineer.class.getName());
	private String programmingLanguage;

	public SoftwareDevelopmentEngineer() {
	}

	public SoftwareDevelopmentEngineer(String name, int employeeId, double salary, String specialty,
			String programmingLanguage) {
		super(name, employeeId, salary, specialty);
		this.programmingLanguage = programmingLanguage;
	}

//Overriding method
	@Override
	public void displayDetails() {
		super.displayDetails();
		log.info("Programming Language: " + programmingLanguage);
	}
}

public class InheritanceDemo {
	static Logger log = LogManager.getLogger(InheritanceDemo.class.getName());
	
	public static void main(String[] args) {
		Accountant accountant = new Accountant("Vidhi", 1001, 200, "CFA");
		log.info("Accountant Details:");
		accountant.displayDetails();

		Engineer engineer = new Engineer("Teesha", 1002, 100, "ETRX");
		log.info("");
		log.info("Engineer Details:");
		engineer.displayDetails();
		log.info("Engineer specialty: " + engineer.getSpecialty());

		SoftwareDevelopmentEngineer sde = new SoftwareDevelopmentEngineer("Saachi", 1003, 300, "Computer Science",
				"Java, Python");
		log.info("");
		log.info("Software Development Engineer Details:");
		sde.displayDetails();
		log.info("SDE specialty: " + sde.getSpecialty());
	}
}