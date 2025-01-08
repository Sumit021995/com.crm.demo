package sampleDataFetch;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;
import objectRepo.LoginPage;

public class UtilizeLoginPage 
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		PropertiesUtility pUtility = new PropertiesUtility();
		String url = pUtility.getDataFromPropertiesFile("url");
		String UN = pUtility.getDataFromPropertiesFile("username");
		String PWD = pUtility.getDataFromPropertiesFile("password");
		driver.get(url);
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(UN, PWD);
		Thread.sleep(2000);
		
		
	}
	
//	public static WebDriver loginToCrmApplication(WebDriver driver) throws Exception
//	{
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		PropertiesUtility pUtility = new PropertiesUtility();
//		String url = pUtility.getDataFromPropertiesFile("url");
//		String UN = pUtility.getDataFromPropertiesFile("username");
//		String PWD = pUtility.getDataFromPropertiesFile("password");
//		driver.get(url);
//		LoginPage login = new LoginPage(driver);
//		login.loginToApplication(UN, PWD);
//		Thread.sleep(2000);
//		return driver;
//	}
	
}
