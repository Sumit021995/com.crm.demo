package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtility {

	Connection con;
	PreparedStatement ps;
	Statement statement;
	
	public static void main(String[] args) throws Exception {
		DatabaseUtility db=new DatabaseUtility();
		db.connectToDatabase("jdbc:mysql://localhost:3306/crmData", "root", "Infocus4999@123");
		String UN=db.fetchDataFromTable("CommonData", 3);
		String PWD=db.fetchDataFromTable("CommonData", 4);
		System.out.println(UN);
		System.out.println(PWD);
//		db.updateDataIntoTable("admin23456", "admin23456");
		db.closeDBConnection();
	}
	
	public void connectToDatabase(String dbUrl, String UN, String PWD) throws Exception
	{
		con = DriverManager.getConnection(dbUrl, UN, PWD);
	}
	
	public void updateDataIntoTable(String username, String password) throws Exception
	{
		String query="insert into credential (username,password) values (?, ?);";
		ps = con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		int rs=ps.executeUpdate();
		if(rs>0)
		{
			System.out.println("A new row inserted");
		}
		else
		{
			System.out.println("duplicate row already exists");
		}
	}
	
	public String fetchDataFromTable(String tablename, int columnNo) throws Exception
	{
		String query="select * from "+tablename;
		statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);

		while(result.next())
		{
			return result.getString(columnNo);
		}
		return null;
	}
	
	public void closeDBConnection() throws Exception
	{
		statement.close();
		con.close();
		System.out.println("DB closed");
	}
}
