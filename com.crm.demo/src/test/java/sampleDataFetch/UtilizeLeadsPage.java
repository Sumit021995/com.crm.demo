package sampleDataFetch;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class UtilizeLeadsPage {
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		UtilizeLoginPage.loginToCrmApplication();
		LeadsPage lp = new LeadsPage(driver);
		
		
	}
}
