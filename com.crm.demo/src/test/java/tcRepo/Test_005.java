package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import objectRepo.ContactsPage;
import objectRepo.CreateContactsPage;
import objectRepo.HomePage;

public class Test_005 extends BaseClass
{
	@Test
	public void contacts_002() throws Exception
	{
		int randomNumber = new JavaUtility().generateRandomNumber(10000);
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenuBtn();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPlusIcon();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Contacts", 5, 1)+randomNumber;
		String lName=eUtil.fetchingDataFromExcelFile("Contacts", 5, 2)+randomNumber;
		String title=eUtil.fetchingDataFromExcelFile("Contacts", 5, 3)+randomNumber;
		String email=eUtil.fetchingDataFromExcelFile("Contacts", 5, 5);
		CreateContactsPage cncp=new CreateContactsPage(driver);
		cncp.createContactOperation(fName, lName, title, email);
		System.out.println("Test Execution Ended");
	}
		
}
