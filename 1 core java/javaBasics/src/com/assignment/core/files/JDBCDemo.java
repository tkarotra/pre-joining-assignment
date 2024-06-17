package com.assignment.core.files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCDemo {
	static Logger log = LogManager.getLogger(JDBCDemo.class.getName());
	
	public static void main(String[] args) {
		log.info("---------------------------------------------------------");

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "root");
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS authentication");
			log.info("Database created successfully.");

			statement.executeUpdate("USE authentication");

			statement.executeUpdate("CREATE TABLE users (user_id INT NOT NULL AUTO_INCREMENT UNIQUE,"
					+ "name VARCHAR(60) NOT NULL, email VARCHAR(50) NOT NULL UNIQUE,"
					+ "country VARCHAR(60) NOT NULL, country_code_name VARCHAR(2) NOT NULL,"
					+ "country_code INT NOT NULL, phone_number VARCHAR(15) NOT NULL,"
					+ "user_password VARCHAR(15) NOT NULL, PRIMARY KEY(user_id))");
            log.info("Table 'users' created successfully.");
            
            statement.executeUpdate("INSERT INTO users (name, email, country, country_code_name, country_code, phone_number, user_password) VALUES " +
                    "('Teesha', 'teesha@gmail.com', 'USA', 'US', 1, '1234567890', 'password1'), " +
                    "('Vidhi', 'vidhi@gmail.com', 'Canada', 'IN', 91, '0987654321', 'password2'), " +
                    "('Saachi', 'saachi@gmail.com', 'United Kingdom', 'UK', 44, '1122334455', 'password3')");
            log.info("3 rows inserted in 'users' table successfully.\n");
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users ORDER BY country_code DESC");
            log.info("Query: SELECT * FROM users ORDER BY country_code DESC");
            log.info("Query results:");
            while (resultSet.next()) {
                log.info("User ID: " + resultSet.getInt("user_id"));
                log.info("Name: " + resultSet.getString("name"));
                log.info("Email: " + resultSet.getString("email"));
                log.info("Country: " + resultSet.getString("country"));
                log.info("Country Code Name: " + resultSet.getString("country_code_name"));
                log.info("Country Code: " + resultSet.getInt("country_code"));
                log.info("Phone Number: " + resultSet.getString("phone_number"));
                log.info("User Password: " + resultSet.getString("user_password"));
                log.info("");
            }
            log.info("------------------------------------------------------------------\n");
            log.info("Query: SELECT name, country, country_code FROM users WHERE country_code LIKE '%1%'");
            resultSet = statement.executeQuery("SELECT name, country, country_code FROM users WHERE country_code LIKE '%1%'");
            log.info("Query results:");
            while (resultSet.next()) {
                log.info("Name: " + resultSet.getString("name"));
                log.info("Country: " + resultSet.getString("country"));
                log.info("Country Code: " + resultSet.getInt("country_code"));
                log.info("");
            }

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
