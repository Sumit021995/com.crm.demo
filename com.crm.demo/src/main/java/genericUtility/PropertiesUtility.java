package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * This is a utility class which work with Properties file
 * @author Sumit
 * @version 02.01.25
 * */
public class PropertiesUtility {
	/*
	 * This is a generic method to fetch data from Properties file
	 * @param String key
	 * @Return String 
	 * @throws Exception IOException
	 * */
	public  String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(IPathUtility.propertiesPath);
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
		
		
	}

}

