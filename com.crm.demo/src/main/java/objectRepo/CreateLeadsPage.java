package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadsPage {
	@FindBy(xpath="//input[@name='firstname']") private WebElement firstNameTextField;
	@FindBy(xpath="//input[@name='lastname']") private WebElement lastNameTextField;
	@FindBy(xpath="//input[@name='company']") private WebElement companyTextField;
	@FindBy(id="email") private WebElement emailTextField;
	@FindBy(xpath="//input[@name='firstname']") private WebElement titleTextField;
	@FindBy(xpath="//input[@name='mailingcity']") private WebElement mailingCityTextField;
	@FindBy(xpath="//input[@name='mailingstate']") private WebElement mailingStateTextField;
	@FindBy(xpath="//input[@class='crmButton small save']") private WebElement saveBtn;
	
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getLeadsourceDropdown() {
		return companyTextField;
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
	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void createContactOperation(String firstName,String lastName,String leadSourceValue)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		Select s = new Select(getLeadsourceDropdown());
		s.selectByValue(leadSourceValue);
		getSaveBtn().click();
	}
	
	public void createContactOperation(String firstName,String lastName,String title , String email)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getEmailTextField().sendKeys(email);
		getTitleTextField().sendKeys(title);
		getSaveBtn().click();
	}
	public void createContactOperation(String firstName,String lastName,String title,String email , String city,String state)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getEmailTextField().sendKeys(email);
		getMailingCityTextField().sendKeys(city);
		getMailingStateTextField().sendKeys(state);
		getSaveBtn().click();
	}
	
	
}

