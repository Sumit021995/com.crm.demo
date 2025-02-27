package sampleDataFetch;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMPractice {
	@FindBy(xpath="//input[@id='name']") 
	private WebElement nameTextField;
	
	public POMPractice(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		POMPractice p = new POMPractice(driver);
		p.nameTextField.sendKeys("Sumit");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		p.nameTextField.sendKeys("Saurav");
		Thread.sleep(2000);
		
	}
	
}
