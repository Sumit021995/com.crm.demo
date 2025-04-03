package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationsPage {
	

@FindBy(xpath="//img[@title='Select']") private WebElement memberPlusIcon;
@FindBy(name="accountname") private WebElement orgNameTextField;
@FindBy(name="website") private WebElement websiteTextField;
@FindBy(name="tickersymbol") private WebElement tickerTextField;
@FindBy(id="employees") private WebElement employeeTextField;
@FindBy(id="email2") private WebElement email2TextField;
@FindBy(id="email1") private WebElement email1TextField;
@FindBy(id="phone") private WebElement phoneTextField;
@FindBy(id="fax") private WebElement faxTextField;
@FindBy(id="otherphone") private WebElement otherphoneTextField;
@FindBy(id="ownership") private WebElement ownershipTextField;
@FindBy(id="siccode") private WebElement sicCodeTextField;
@FindBy(name="annual_revenue") private WebElement annualRevenueTextField;
@FindBy(name="bill_street") private WebElement bill_streetTextArea;
@FindBy(name="cpy") private WebElement copyBillAddressRadioBtn;
@FindBy(name="button") private WebElement saveBtn;

public WebElement getMemberPlusIcon() {
	return memberPlusIcon;
}

public WebElement getOrgNameTextField() {
	return orgNameTextField;
}

public WebElement getWebsiteTextField() {
	return websiteTextField;
}

public WebElement getTickerTextField() {
	return tickerTextField;
}

public WebElement getEmployeeTextField() {
	return employeeTextField;
}

public WebElement getEmail2TextField() {
	return email2TextField;
}

public WebElement getEmail1TextField() {
	return email1TextField;
}

public WebElement getPhoneTextField() {
	return phoneTextField;
}

public WebElement getFaxTextField() {
	return faxTextField;
}

public WebElement getOtherphoneTextField() {
	return otherphoneTextField;
}

public WebElement getOwnershipTextField() {
	return ownershipTextField;
}

public WebElement getSicCodeTextField() {
	return sicCodeTextField;
}

public WebElement getAnnualRevenueTextField() {
	return annualRevenueTextField;
}

public WebElement getBill_streetTextArea() {
	return bill_streetTextArea;
}

public WebElement getCopyBillAddressRadioBtn() {
	return copyBillAddressRadioBtn;
}

public WebElement getSaveBtn() {
	return saveBtn;
}


public CreateOrganizationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}



}
