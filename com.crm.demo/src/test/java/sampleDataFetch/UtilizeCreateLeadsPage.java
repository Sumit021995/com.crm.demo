package sampleDataFetch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class UtilizeCreateLeadsPage {
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		PropertiesUtility pUtility  = new PropertiesUtility();
		String URL = pUtility.getDataFromPropertiesFile("url");
		String UN = pUtility.getDataFromPropertiesFile("username");
		String PWD = pUtility.getDataFromPropertiesFile("password");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		HomePage hp = new HomePage(driver);
		
		
	}
}
