package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement plusIcon;
	@FindBy(xpath="//span[text()='Creating New Lead']") private WebElement CreateLeadsPageText;
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	public WebElement getCreateLeadsPageText() {
		return CreateLeadsPageText;
	}
	
	
}
