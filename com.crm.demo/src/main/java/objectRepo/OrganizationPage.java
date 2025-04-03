package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement createOrgPlusIcon;

	public WebElement getCreateOrgPlusIcon() {
		return createOrgPlusIcon;
	}
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
