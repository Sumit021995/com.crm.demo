package genericUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This is an Utility class which contains generic methods for selenium library
 * @author-Sumit
 * @version-01.10.25
 */
public class SeleniumUtility {
	
	/**
	 * This is the generic method to open an application
	 * @param driver
	 * @param url
	 */
	public void accesToApplication(WebDriver driver,String url)
	{
		driver.get(url);
	}
	/**
	 * This is the generic method to perform  browser maximization
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This is the generic method to apply implicit wait to the script
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver,int maxTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
	
	////////////******Handling Dropdowns*******/////////////
	/**
	 * This is the generic method to select an option from dropdown based on index
	 * @param dropDownElement
	 * @param index
	 */
	public void selectOptionUsinIndex(WebElement dropDownElement, int index)
	{
		Select s = new Select(dropDownElement);
		s.selectByIndex(index);
	}
	/**
	 * This is the generic method to select an option from dropdown based on attribute value
	 * @param dropDownElement
	 * @param attributeValue
	 */
	public void selectOptionUsinValue(WebElement dropDownElement, String attributeValue)
	{
		Select s = new Select(dropDownElement);
		s.selectByValue(attributeValue);
	}
	/**
	 * This is the generic method to select an option from dropdown based on visible text
	 * @param dropDownElement
	 * @param visibleText
	 */
	public void selectOptionUsinVisibleText(WebElement dropDownElement, String visibleText)
	{
		Select s = new Select(dropDownElement);
		s.selectByVisibleText(visibleText);
	}
	
	////////////******Handling Alerts*******/////////////
	
	/**
	 * This is a  generic method to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	/**
	 * This is a  generic method to dismiss the alert popup
	 * @param driver
	 */
	public void dismisAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	/**
	 * This is a  generic method to get text value of  the alert popup
	 * @param driver
	 * @return String
	 */
	public String getAlertMessage(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
		
	}
	
}
