package sampleDataFetch;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice 
{
//	@FindBy(xpath="//span[text()='Electronics']") static WebElement electronicText;
//	@FindBy(xpath="//a[text()='Cameras & Accessories']") static WebElement cameraIcon;
//	@FindBy(xpath="//a[text()='All']") static WebElement allText;
//	
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		WebElement electronicText = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(electronicText).perform();
		WebElement cameraIcon = driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"));
		act.moveToElement(cameraIcon).perform();
		WebElement allText = driver.findElement(By.xpath("//a[text()='All']"));
		act.moveToElement(allText).click().perform();
		Thread.sleep(2000);
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='kv0tEm']")).click();
		Thread.sleep(2000);
		Set<String> ids=driver.getWindowHandles();
		for(String s : ids)
		{
			if(!parentId.equals(s))
				driver.switchTo().window(s);
		}
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.xpath("//span[@class='VU-ZEz']"));
		String productName = product.getText();
		Thread.sleep(2000);
		WebElement addToCart = driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']"));
		act.moveToElement(addToCart).click().perform();
		WebElement text = driver.findElement(By.xpath("//a[@class='T2CNXf QqLTQ-']"));
		Thread.sleep(2000);
		String value = text.getText();
		if(value.contains(productName))
		{
			System.out.println("Validated True");
		}
		WebElement priceText = driver.findElement(By.xpath("//span[@class='LAlF6k re6bBo']"));
	
		System.out.println(priceText.getText());
		
		
		
		
		
		
		
	}
}
