package com.assignment.core.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONDemo {
	static Logger log = LogManager.getLogger(JSONDemo.class.getName());

	public static void main(String[] args) {
		log.info("---------------------------------------------------------");
//		Create JSON Objects
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("id", "P001");
		jsonObject1.put("name", "Teesha Karotra");
		jsonObject1.put("age", 22);
		jsonObject1.put("salary", 12000);

		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", "P002");
		jsonObject2.put("name", "Vidhi Karotra");
		jsonObject2.put("age", 18);
		jsonObject2.put("salary", 31000);

//		Add JSON Objects to JSON Array
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		String filePath = "persons.json";

//		Create File
		try {
			FileWriter file = new FileWriter(filePath);
			file.write(jsonArray.toJSONString());
			file.close();
			log.info("JSON File Created Successfully.");
		} catch (IOException e) {
			log.error(e.getMessage());
		}

//		Update File
		log.info("Updating the JSON File Created.");
		try {
//			Get JSON File Data
			JSONParser parser = new JSONParser();
			jsonArray = (JSONArray) (parser.parse(new FileReader(filePath)));
			/*for (Object person: jsonArray) {
				JSONObject jsonObject = (JSONObject)person;
				System.out.println(jsonObject);
				if ("P002".equals((String)jsonObject.get("id"))) {
					System.out.println("if");
					jsonObject.put("name", "Saachi Karotra");
				}
			}*/
//			Iterate over JSON Array and update name of JSON Object with id = P002
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) (iterator.next());
				if ("P002".equals((String) jsonObject.get("id"))) {
					jsonObject.put("name", "Saachi Karotra");
				}
			}
//			Save (Write) changes to JSON Array to the file
			FileWriter file = new FileWriter(filePath);
			file.write(jsonArray.toJSONString());
			file.close();
		} catch (IOException | ParseException e) {
			log.error(e.getMessage());
		}

//		Read File
		log.info("Reading the JSON File Created.");
		try {
//			Get JSON File Data
			JSONParser parser = new JSONParser();
			jsonArray = (JSONArray) (parser.parse(new FileReader(filePath)));
//			Iterate over JSON Array and log data
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				log.info("{");
				JSONObject jsonObject = (JSONObject) (iterator.next());
				log.info("\tId: " + jsonObject.get("id"));
				log.info("\tName: " + jsonObject.get("name"));
				log.info("\tAge: " + jsonObject.get("age"));
				log.info("\tSalary: " + jsonObject.get("salary"));
				log.info("},");
			}
		} catch (IOException | ParseException e) {
			log.error(e.getMessage());
		}
	}
}
