package sampleDataFetch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		ResultSet result = statement.executeQuery(query);
		
		while(result.next())
		{
			String browser = result.getString(1);
			String url = result.getString(2);
			String uname = result.getString(3);
			String pwd = result.getString(4);
			System.out.println(browser+" ");
			System.out.println(url+" ");
			System.out.println(uname+" ");
			System.out.println(pwd);
		}
		
		connection.close();
		statement.close();
		
		
	}
}
