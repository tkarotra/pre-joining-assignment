package com.assignment.core.collectionsFramework;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Custom Employee class
class Employee implements Comparable {
	private String name, id;
	private int salary;

	public Employee() {
	}

	public Employee(String id, String name, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Name: " + name + ", Salary: " + salary;
	}

	@Override
	public boolean equals(Object employee) {
		if (employee instanceof Employee) {
			return id == ((Employee) employee).id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

// Override compareTo method to sort employee objects in ascending order of their id
	@Override
	public int compareTo(Object employee) {
		if (employee instanceof Employee) {
			return id.compareTo(((Employee) employee).id);
		} else {
			throw new RuntimeException();
		}
	}
}

class EmployeeSorting implements Comparator<Employee> {
// Override compare method to sort employee objects in descending order of their id
	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee2.getId().compareTo(employee1.getId());
	}
}

public class CollectionsDemo {
	static Logger log = LogManager.getLogger(CollectionsDemo.class.getName());

	public static void main(String[] args) {
		// Java ArrayList methods (List interface)
		log.info("------------------------ List (Primitives) ------------------------");
		List<String> fruitsList = new ArrayList<String>();
		fruitsList.add("Mango");
		fruitsList.add("Apple");
		fruitsList.add("Lychee");
		fruitsList.add("Banana");
		fruitsList.add("Grapes");
		log.info("List: " + fruitsList);
		log.info("List size: " + fruitsList.size());
		log.info("Index of 'Banana': " + fruitsList.indexOf("Banana"));
		log.info("Remove 'Lychee' element: " + fruitsList.remove("Lychee"));
		log.info("Does List contain 'Lychee': " + fruitsList.contains("Lychee"));
		fruitsList.set(1, "Lychee");
		log.info("Get list element at index 1: " + fruitsList.get(1) + "\n");

		Collections.sort(fruitsList);
		log.info("Sorted list: " + fruitsList);
		String[] fruitsArray = fruitsList.toArray(new String[fruitsList.size()]);
		log.info("Array of List elements: " + Arrays.toString(fruitsArray));

		log.info("Array to List: " + Arrays.asList(fruitsArray) + "\n");

		ListIterator<String> iterator = fruitsList.listIterator();
		log.info("Traversing in forward direction");
		while (iterator.hasNext()) {
			log.info("index: " + iterator.nextIndex() + ", value: " + iterator.next());
		}
		log.info("");
		log.info("Traversing in backward direction");
		while (iterator.hasPrevious()) {
			log.info("index: " + iterator.previousIndex() + ", value: " + iterator.previous());
		}

		fruitsList.clear();
		log.info("");
		log.info("Is List empty: " + fruitsList.isEmpty());

		log.info("\n\n");
		log.info("------------------------ List (Custom object) ------------------------");
		Employee employee1 = new Employee("A2", "Vidhi", 50000);
		Employee employee2 = new Employee("B1", "Teesha", 60000);
		Employee employee3 = new Employee("A1", "Saachi", 40000);
		List<Employee> employeesArrayList = new ArrayList<>();
		employeesArrayList.add(employee1);
		employeesArrayList.add(employee2);
		employeesArrayList.add(employee3);

		// Sorting using Comparable
		log.info("Sorted List of Employees using Comparable: ");
		Collections.sort(employeesArrayList);
		for (Employee employee : employeesArrayList) {
			log.info(employee);
		}

		log.info("\n\n");
		log.info("------------------------ Set (Primitives) ------------------------");
		String[] vowels = { "a", "e", "i" };
		Set<String> vowelsSet = new LinkedHashSet<>();
		Collections.addAll(vowelsSet, vowels);
		vowelsSet.add("o");
		vowelsSet.add("u");
		vowelsSet.add("U");
		log.info("Vowels LinkedHashSet Size: " + vowelsSet.size());
		vowelsSet.remove("U");
		log.info("Vowels LinkedHashSet: " + vowelsSet);
		log.info("Vowels LinkedHashSet contains 'o': " + vowelsSet.contains("o"));
		vowelsSet.clear();
		log.info("Vowels LinkedHashSet is empty: " + vowelsSet.isEmpty());

		log.info("\n\n");
		log.info("------------------------ Set (Custom object) ------------------------");
		Set<Employee> employeesTreeSet = new TreeSet<Employee>(new EmployeeSorting());
		employeesTreeSet.add(employee1);
		employeesTreeSet.add(employee2);
		employeesTreeSet.add(employee3);

		// Sorting using Comparator
		log.info("Sorted TreeSet of Employees using Comparator: ");
		for (Employee employee : employeesTreeSet) {
			log.info(employee);
		}

		log.info("\n\n");
		log.info("------------------------ Map (Primitives & Custom Object) ------------------------");
		Map<String, Employee> employeesHashMap = new HashMap<String, Employee>();
		employeesHashMap.put("Emp1", employee1);
		employeesHashMap.put("Emp2", employee2);
		employeesHashMap.put("Emp3", employee3);
		employeesHashMap.put(null, employee3);

		log.info("Value of entry with key 'Emp1': " + employeesHashMap.get("Emp1") + "\n");
		log.info("Employees HashMap: " + employeesHashMap + "\n");

		employeesHashMap.replace(null, employee3, employee1);
		log.info("Value of entry with key 'null': " + employeesHashMap.get(null) + "\n");

		employeesHashMap.remove(null);
		log.info("Employees HashMap (removed null key entry): " + employeesHashMap);

		log.info("Contains Key 'Emp4' in HashMap: " + employeesHashMap.containsKey("Emp4"));
		log.info("Contains Value 'employee1' object in HashMap: " + employeesHashMap.containsValue(employee1) + "\n");
		log.info("Keys in HashMap: " + employeesHashMap.keySet());
		log.info("Values in HashMap: " + employeesHashMap.values());
	}
}
