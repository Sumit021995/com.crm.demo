package sampleDataFetch;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import genericUtility.PropertiesUtility;


public class FetchDataFromMySqlDatabase {
	public static void main(String[] args) throws SQLException, IOException {
		PropertiesUtility pUtility = new PropertiesUtility();
		String DBUN = pUtility.getDataFromPropertiesFile("DBUN");
		String DBURL = pUtility.getDataFromPropertiesFile("DBURL");
		String DBPWD = pUtility.getDataFromPropertiesFile("DBPWD");
		DriverManager.getConnection(DBURL, DBUN, DBPWD);
		
		
	}
}
