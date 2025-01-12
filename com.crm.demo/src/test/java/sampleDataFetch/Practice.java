package sampleDataFetch;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class Practice 
{
	@FindBy(xpath="//span[text()='Electronics']")  WebElement electronicText;
	@FindBy(xpath="//a[text()='Cameras & Accessories']")  WebElement cameraIcon;
	@FindBy(xpath="//a[text()='All']")  WebElement allText;
	@FindBy(xpath="//div[@class='kv0tEm']")  WebElement firstProduct;
	@FindBy(xpath="//span[@class='VU-ZEz']")  WebElement productName;
	@FindBy(xpath="//button[@class='QqFHMw vslbG+ In9uk2']")  WebElement addToCartButton;
	@FindBy(xpath="//a[@class='T2CNXf QqLTQ-']")  WebElement productAtCart;
	@FindBy(xpath="//span[@class='LAlF6k re6bBo']")  WebElement productPrice;
//	
	public Practice(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		Practice p = new Practice(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
//		WebElement electronicText = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(p.electronicText).perform();
//		WebElement cameraIcon = driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"));
		act.moveToElement(p.cameraIcon).perform();
//		WebElement allText = driver.findElement(By.xpath("//a[text()='All']"));
		act.moveToElement(p.allText).click().perform();
		Thread.sleep(2000);
		String parentId = driver.getWindowHandle();
//		driver.findElement(By.xpath("//div[@class='kv0tEm']"))
		p.firstProduct.click();
		Thread.sleep(2000);
		SeleniumUtility su = new SeleniumUtility();
		su.switchToNewWindow(driver);
//		Set<String> ids=driver.getWindowHandles();
//		for(String s : ids)
//		{
//			if(!parentId.equals(s))
//				driver.switchTo().window(s);
//		}
		Thread.sleep(2000);
//		WebElement product = driver.findElement(By.xpath("//span[@class='VU-ZEz']"));
		String productName = p.productName.getText();
		System.out.println(productName);
		System.out.println("+++++++++++");
		Thread.sleep(2000);
//		WebElement addToCart = driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']"));
		act.moveToElement(p.addToCartButton).click().perform();
//		WebElement text = driver.findElement(By.xpath("//a[@class='T2CNXf QqLTQ-']"));
		Thread.sleep(2000);
		String value = p.productAtCart.getText();
		System.out.println(value);
		if(productName.contains(value))
		{
			System.out.println("Validated True");
		}
//		WebElement priceText = driver.findElement(By.xpath("//span[@class='LAlF6k re6bBo']"));
	
		System.out.println(p.productPrice.getText());
		
		driver.quit();
		
		
		
		
		
		
	}
}

