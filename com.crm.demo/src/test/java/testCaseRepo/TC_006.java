package testCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import objectRepo.ContactsPage;
import objectRepo.CreateContactsPage;
import objectRepo.HomePage;

public class TC_006 extends BaseClass
{
	@Test
	public void contacts_003() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenuBtn();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPlusIcon();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Contacts", 8, 1);
		String lName=eUtil.fetchingDataFromExcelFile("Contacts", 8, 2);
		String title=eUtil.fetchingDataFromExcelFile("Contacts", 8, 3);
		String email=eUtil.fetchingDataFromExcelFile("Contacts", 8, 4);
		String mailingCity=eUtil.fetchingDataFromExcelFile("Contacts", 8, 5);
		String mailingState=eUtil.fetchingDataFromExcelFile("Contacts", 8, 6);
		
		CreateContactsPage cncp=new CreateContactsPage(driver);
		cncp.createContactOperation(fName, lName, title, email, mailingCity, mailingState);
		System.out.println("Test Execution Ended");
	}

}
