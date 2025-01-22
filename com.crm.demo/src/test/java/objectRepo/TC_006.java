package objectRepo;

import org.testng.annotations.Test;

import PomClassesRepo.ContactsPage;
import PomClassesRepo.CreatingNewContactPage;
import PomClassesRepo.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelUtility;

public class TC_006 extends BaseClass
{
	@Test
	public void contacts_003() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactButton();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.getDataFromExcel("Contacts", 8, 1);
		String lName=eUtil.getDataFromExcel("Contacts", 8, 2);
		String title=eUtil.getDataFromExcel("Contacts", 8, 3);
		String email=eUtil.getDataFromExcel("Contacts", 8, 4);
		String mailingCity=eUtil.getDataFromExcel("Contacts", 8, 5);
		String mailingState=eUtil.getDataFromExcel("Contacts", 8, 6);
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContacts(fName, lName, title, email, mailingCity, mailingState);
		System.out.println("Test Execution Ended");
	}

}
