package com.assignment.dbms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatementsProcedureDemo {
	static Logger log = LogManager.getLogger(StatementsProcedureDemo.class.getName());
	
	public static void main(String[] args) {
        try {
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false", "root", "root");
        	
//        	PreparedStatement
            log.info("---------------- PreparedStatement ----------------");
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM countrylanguage WHERE CountryCode = ?");
            preparedStatement.setString(1, "IND");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String language = resultSet.getString("Language");
                String isOfficial = resultSet.getString("IsOfficial");
                double percentage = resultSet.getDouble("Percentage");
                log.info("Language: " + language + ", IsOfficial: " + isOfficial + ", Percentage: " + percentage);
            }

            preparedStatement = conn.prepareStatement("UPDATE countrylanguage SET Percentage = ? WHERE CountryCode = ?");
            preparedStatement.setDouble(1, 75.0);
            preparedStatement.setString(2, "FRA");
            int rowsUpdated = preparedStatement.executeUpdate();
            log.info("Rows updated: " + rowsUpdated + "\n");
            
            
//          CallableStatement
            log.info("---------------- CallableStatement ----------------");
            CallableStatement callableStatement = conn.prepareCall("{call update_percentage(?, ?)}");
            callableStatement.setString(1, "USA");
            callableStatement.setDouble(2, 60.0);
            callableStatement.execute();
            log.info("Percentage updated successfully.");
            
            callableStatement = conn.prepareCall("{call get_country_language_info(?, ?, ?, ?)}");
            callableStatement.setString(1, "IND");
            callableStatement.registerOutParameter(2, Types.INTEGER); // officialLanguageCount
            callableStatement.registerOutParameter(3, Types.INTEGER); // totalLanguageCount
            callableStatement.registerOutParameter(4, Types.DECIMAL); // officialLanguagePercentage
            callableStatement.execute();
            
            int officialLanguageCount = callableStatement.getInt(2);
            int totalLanguageCount = callableStatement.getInt(3);
            double officialLanguagePercentage = callableStatement.getDouble(4);
            log.info("Country Code: IND");
            log.info("Official Language Count: " + officialLanguageCount);
            log.info("Total Language Count: " + totalLanguageCount);
            log.info("Official Language Percentage: " + officialLanguagePercentage);
        } catch (Exception e) {
            log.info(e);
        }
    }
}
