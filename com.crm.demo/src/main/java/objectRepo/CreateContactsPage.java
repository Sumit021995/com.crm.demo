package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateContactsPage {
	@FindBy(xpath="//input[@name='firstname']") private WebElement firstNameTextField;
	@FindBy(xpath="//input[@name='lastname']") private WebElement lastNameTextField;
	@FindBy(xpath="//input[@name='leadsource']") private WebElement leadsourceDropdown;
	@FindBy(id="email") private WebElement emailTextField;
	@FindBy(xpath="//input[@name='firstname']") private WebElement titleTextField;
	@FindBy(xpath="//input[@name='mailingcity']") private WebElement mailingCityTextField;
	@FindBy(xpath="//input[@name='mailingstate']") private WebElement mailingStateTextField;
	@FindBy(xpath="//input[@name='button']") private WebElement saveBtn;
	
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getLeadsourceDropdown() {
		return leadsourceDropdown;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getTitleTextField() {
		return titleTextField;
	}
	public WebElement getMailingCityTextField() {
		return mailingCityTextField;
	}
	public WebElement getMailingStateTextField() {
		return mailingStateTextField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void createContactOperation(String firstName,String lastName,String email,String city,String state,String value)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getEmailTextField().sendKeys(email);
		getMailingCityTextField().sendKeys(city);
		getMailingStateTextField().sendKeys(state);
		Select s = new Select(getLeadsourceDropdown());
		s.selectByValue(value);
		getSaveBtn().click();
	}
	
	
}
