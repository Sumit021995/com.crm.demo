package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class HomePage {
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']") private WebElement leadMenuBtn;
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Contacts']") private WebElement contactMenuBtn;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement AccountIcon;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signOutOption;
	@FindBy(xpath="//table[@class='hdrTabBg']//a[text()='Organizations']") private WebElement organizationIconLink;

//	@FindAll({@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']"),@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Contacts']")}) WebElement ele;	
	public WebElement getLeadMenuBtn() {
		return leadMenuBtn;
	}
	public WebElement getOrganizationIconLink() {
		return organizationIconLink;
	}
	public WebElement getContactMenuBtn() {
		return contactMenuBtn;
	}
	public WebElement getAccountIcon() {
		return AccountIcon;
	}
	public WebElement getSignOutOption() {
		return signOutOption;
	}
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This is a Bussiness Library Method to perform click operation on LeadMenu Button from HomePage
	 */
	public void clickOnLeadMenuBtn()
	{
		getLeadMenuBtn().click();
	}
	/**
	 * This is a Bussiness Library Method to perform click operation on ContactMenu Button from HomePage
	 */
	public void clickOnContactMenuBtn()
	{
		getContactMenuBtn().click();
	}
	/**
	 * This is a Bussiness Library Method to perform click operation SignOut Operation
	 */
	public void signOutOperation(WebDriver driver)
	{
//		new SeleniumUtility().waitForElementToBeVisible(driver,10,getAccountIcon());
		Actions act =new Actions(driver);
		act.moveToElement(getAccountIcon()).click().perform();
		getSignOutOption().click();
	}
	
	
}
