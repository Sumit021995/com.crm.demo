package testCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import objectRepo.ContactsPage;
import objectRepo.CreateContactsPage;
import objectRepo.HomePage;

public class TC_004 extends BaseClass
{
	@Test
	public void contacts_001() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenuBtn();
	
		//LeadsPage lp=new LeadsPage(driver);
		ContactsPage cp=new ContactsPage(driver);
		//lp.clickOnLeadsContactButton();
		cp.clickOnCreateContactPlusIcon();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Contacts", 2, 1);
		String lName=eUtil.fetchingDataFromExcelFile("Contacts", 2, 2);
		String leadSource=eUtil.fetchingDataFromExcelFile("Contacts", 2, 3);
		CreateContactsPage cncp=new CreateContactsPage(driver);
		cncp.createContactOperation(fName, lName, leadSource);
		System.out.println("Test Execution Ended");
		
	}
}
