package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement createLeadsPlusIcon;
	@FindBy(xpath="//span[text()='Creating New Lead']") private WebElement CreateLeadsPageText;
	
	public WebElement getcreateLeadsPlusIcon() {
		return createLeadsPlusIcon;
	}
	public WebElement getCreateLeadsPageText() {
		return CreateLeadsPageText;
	}
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This is a Bussiness library to click on create new Leads Plus Icon
	 */
	public void clickOnCreateLeadsPlusIcon()
	{
		getcreateLeadsPlusIcon().click();
	}
	public void verifyCreateLeadPage()
	{
		if(getCreateLeadsPageText().getText().equals("Creating New Lead"))
			System.out.println("Validated True");
	}
	
	
	
}
