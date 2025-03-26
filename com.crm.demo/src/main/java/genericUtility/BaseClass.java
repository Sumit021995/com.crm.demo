package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;		//only for listeners
	public SeleniumUtility sUtil=new SeleniumUtility();
	public PropertiesUtility pUtil=new PropertiesUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public DatabaseUtility dbUtil=new DatabaseUtility();
	public static ThreadLocal<WebDriver> driverInstance = new ThreadLocal();
	
	@BeforeSuite(alwaysRun = true)
	public void dbConnection() throws Exception
	{
		String dbURL=pUtil.getDataFromPropertiesFile("DBURL");
		String dbUN=pUtil.getDataFromPropertiesFile("DBUN");
		String dbPWD=pUtil.getDataFromPropertiesFile("DBPWD");
		dbUtil.connectToDatabase(dbURL, dbUN, dbPWD);
		System.out.println("DB connection created");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String BROWSER) throws Exception
	{
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
//		sDriver=driver;		//this sDriver is initialized and will be used in Listeners
		setDriver(driver);
		sUtil.implicitWait(driver, 15);
		sUtil.maximizeWindow(driver);
		String URL=pUtil.getDataFromPropertiesFile("url");
		sUtil.accesToApplication(driver, URL);
		System.out.println("Browser launched successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginOperation() throws Exception
	{
		String UN=dbUtil.fetchDataFromTable("CommonData", 3);
		String PWD=dbUtil.fetchDataFromTable("CommonData", 4);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		System.out.println("Login done successfully");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutOperation() throws InterruptedException
	{
		Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		hp.signOutOperation(driver);
		System.out.println("Sign out done successfully");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser closed successfully");
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDBConnection() throws Exception
	{
		dbUtil.closeDBConnection();
		System.out.println("DB connection closed");
	}
	public static WebDriver getDriver()
	{
		return driverInstance.get();
	}
	public static void setDriver(WebDriver driver)
	{
		driverInstance.set(driver);
	}
}