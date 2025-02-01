package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import objectRepo.ContactsPage;
import objectRepo.CreateContactsPage;
import objectRepo.HomePage;

public class TC_005 extends BaseClass
{
	@Test
	public void contacts_002() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenuBtn();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPlusIcon();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Contacts", 5, 1);
		String lName=eUtil.fetchingDataFromExcelFile("Contacts", 5, 2);
		String title=eUtil.fetchingDataFromExcelFile("Contacts", 5, 3);
		String email=eUtil.fetchingDataFromExcelFile("Contacts", 5, 4);
		CreateContactsPage cncp=new CreateContactsPage(driver);
		cncp.createContactOperation(fName, lName, title, email);;
		System.out.println("Test Execution Ended");
	}
		
}
