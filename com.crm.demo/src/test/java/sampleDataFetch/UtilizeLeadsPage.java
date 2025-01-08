package sampleDataFetch;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepo.LoginPage;

public class UtilizeLeadsPage {
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
	}
}
