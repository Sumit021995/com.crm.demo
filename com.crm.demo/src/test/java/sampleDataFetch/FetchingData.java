package sampleDataFetch;

import java.io.IOException;
import java.util.List;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;

public class FetchingData {

	public static void main(String[] args) throws IOException {
		PropertiesUtility pUtility = new PropertiesUtility();
		String url = pUtility.getDataFromPropertiesFile("url");
		String username = pUtility.getDataFromPropertiesFile("username");
		String password = pUtility.getDataFromPropertiesFile("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
//		WebDriver driver = new ChromeDriver();
//		driver.get(url);
//		String excelData = pUtility.fetchingDataFromExcelFile();
//		System.out.println(excelData);
		ExcelUtility eUtility = new ExcelUtility();
		String excelData=eUtility.fetchingDataFromExcelFile("Leads", 2, 1);
		System.out.println(excelData);
		
			List<String> value = eUtility.fetchingMultipleDataFromExcelFile("Animal", 1, 0);
			System.out.println(value);
	}

}
