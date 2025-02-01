package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadsPage 
{
	@FindBy(xpath="//select[@name='salutationtype']") private WebElement titleDropDown;
	@FindBy(xpath="//input[@name='firstname']") private WebElement firstNameTextField;
	@FindBy(xpath="//input[@name='lastname']") private WebElement lastNameTextField;
	@FindBy(xpath="//input[@name='company']") private WebElement companyTextField;
	@FindBy(id="designation") private WebElement titleTextField;
	@FindBy(id="phone") private WebElement phoneNumTextField;
	@FindBy(id="city") private WebElement cityTextField;
	@FindBy(id="state") private WebElement stateTextField;
	@FindBy(id="country") private WebElement countryTextField;
	@FindBy(xpath="//select[@name='leadsource']") private WebElement leadSourceDropDown;
	@FindBy(xpath="//input[@name='website']") private WebElement websiteTextField;
	@FindBy(xpath="//input[@name='industry']") private WebElement industryDropDown;
	@FindBy(xpath="//input[@name='annualrevenue']") private WebElement annualrevenueNumTextField;
	@FindBy(xpath="//input[@name='noofemployees']") private WebElement noOfEmployeesTextField;
	@FindBy(xpath="//input[@class='crmButton small save']") private WebElement saveBtn;
	
	public WebElement getTitleDropDown() {
		return titleDropDown;
	}
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getCompanyTextField() {
		return companyTextField;
	}
	public WebElement getTitleTextField() {
		return titleTextField;
	}
	public WebElement getPhoneNumTextField() {
		return phoneNumTextField;
	}
	public WebElement getCityTextField() {
		return cityTextField;
	}
	public WebElement getStateTextField() {
		return stateTextField;
	}
	public WebElement getCountryTextField() {
		return countryTextField;
	}
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getAnnualrevenueNumTextField() {
		return annualrevenueNumTextField;
	}
	public WebElement getNoOfEmployeesTextField() {
		return noOfEmployeesTextField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void createLeadOperation(String firstName,String lastName,String company)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getSaveBtn().click();
	}
	
	public void createLeadOperation(String firstName,String lastName,String phone , String website)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getPhoneNumTextField().sendKeys(phone);
		getWebsiteTextField().sendKeys(website);
		getSaveBtn().click();
	}
	public void createLeadOperation(String firstName,String lastName,String phone,String website,String noOfEmployee,String country,String city,String state)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getPhoneNumTextField().sendKeys(phone);
		getWebsiteTextField().sendKeys(website);
		getNoOfEmployeesTextField().sendKeys(noOfEmployee);
		getCountryTextField().sendKeys(country);
		getCityTextField().sendKeys(city);
		getStateTextField().sendKeys(state);
		getSaveBtn().click();
	}
}

