package TC_Repo;

import org.testng.annotations.Test;

import PomClassesRepo.ContactsPage;
import PomClassesRepo.CreatingNewContactPage;
import PomClassesRepo.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelUtility;

public class TC_005 extends BaseClass
{
	@Test
	public void contacts_002() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactButton();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.getDataFromExcel("Contacts", 5, 1);
		String lName=eUtil.getDataFromExcel("Contacts", 5, 2);
		String title=eUtil.getDataFromExcel("Contacts", 5, 3);
		String email=eUtil.getDataFromExcel("Contacts", 5, 4);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContacts(fName, lName, title, email);;
		System.out.println("Test Execution Ended");
	}
		
}
