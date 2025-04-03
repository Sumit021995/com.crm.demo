package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import objectRepo.ContactsPage;
import objectRepo.CreateContactsPage;
import objectRepo.HomePage;

public class Test_006 extends BaseClass
{
	@Test
	public void contacts_003() throws Exception
	{
		int randomNumber = new JavaUtility().generateRandomNumber(10000);
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenuBtn();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPlusIcon();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Contacts", 8, 1)+randomNumber;
		String lName=eUtil.fetchingDataFromExcelFile("Contacts", 8, 2)+randomNumber;
		String title=eUtil.fetchingDataFromExcelFile("Contacts", 8, 4)+randomNumber;
		String email=eUtil.fetchingDataFromExcelFile("Contacts", 8, 5);
		String mailingCity=eUtil.fetchingDataFromExcelFile("Contacts", 8, 6)+randomNumber;
		String mailingState=eUtil.fetchingDataFromExcelFile("Contacts", 8, 7)+randomNumber;
		
		CreateContactsPage cncp=new CreateContactsPage(driver);
		cncp.createContactOperation(fName, lName, title, email, mailingCity, mailingState);
		System.out.println("Test Execution Ended");
	}

}
