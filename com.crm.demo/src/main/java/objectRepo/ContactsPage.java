package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement createContactPlusIcon;

	public WebElement getCreateContactPlusIcon() {
		return createContactPlusIcon;
	}

	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * This is a Bussiness library to click on create new Contacts Plus Icon
	 */
	public void clickOnCreateContactPlusIcon()
	{
		getCreateContactPlusIcon().click();
	}
	
}
