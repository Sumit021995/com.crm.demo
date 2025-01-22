package genericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepo.*;


public class BaseClass 
{
	public WebDriver driver;
	public PropertiesUtility pUtil=new PropertiesUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	
	@BeforeSuite
	public void dbConnection()
	{
		System.out.println("Database connected");
	}
	@BeforeClass
	public void launchBrowser() throws Exception
	{
		driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver,15);
		String URl=pUtil.getDataFromPropertiesFile("url");
		sUtil.accesToApplication(driver, URl);
		System.out.println("application accessed");
	}
	@BeforeMethod
	public void loginOperation() throws Exception
	{
		String UN=pUtil.getDataFromPropertiesFile("username");
		String PWD=pUtil.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		System.out.println("login done");
	}
	@AfterMethod
	public void logOutoperation()  throws Exception
	{
		HomePage hp=new HomePage(driver);
		hp.signOutOperation(driver);
		System.out.println("sign out done");
	}
	@AfterClass
	public void closeBrowser() throws Exception
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	@AfterSuite
	public void dbConnectionClose() 
	{
		System.out.println("Database disconnected");
	}
}
