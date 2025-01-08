package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']") private WebElement leadMenuBtn;
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Contacts']") private WebElement contactMenuBtn;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement AccountIcon;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signOutOption;
	
	public WebElement getLeadMenuBtn() {
		return leadMenuBtn;
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
	
	public void clickOnLeadMenuBtn()
	{
		getLeadMenuBtn().click();
	}
	public void clickOnContactMenuBtn()
	{
		getContactMenuBtn().click();
	}
	public void signOutOperation()
	{
		getSignOutOption().click();
		getContactMenuBtn().click();
	}
	
	
}
