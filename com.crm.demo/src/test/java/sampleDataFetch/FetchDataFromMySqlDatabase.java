package sampleDataFetch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import genericUtility.PropertiesUtility;


public class FetchDataFromMySqlDatabase {
	public static void main(String[] args) throws SQLException, IOException {
		PropertiesUtility pUtility = new PropertiesUtility();
		String DBUN = pUtility.getDataFromPropertiesFile("DBUN");
		String DBURL = pUtility.getDataFromPropertiesFile("DBURL");
		String DBPWD = pUtility.getDataFromPropertiesFile("DBPWD");
		Connection connection = DriverManager.getConnection(DBURL, DBUN, DBPWD);
		String query = "select * from CommonData";
		Statement statement = connection.createStatement();
		statement.executeQuery(query);
		
		
	}
}
