package TC_Repo;

import org.testng.annotations.Test;

import PomClassesRepo.ContactsPage;
import PomClassesRepo.CreatingNewContactPage;
import PomClassesRepo.CreatingNewLeadPage;
import PomClassesRepo.HomePage;
import PomClassesRepo.LeadsPage;
import genericUtility.BaseClass;
import genericUtility.ExcelUtility;

public class TC_004 extends BaseClass
{
	@Test
	public void contacts_001() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
	
		//LeadsPage lp=new LeadsPage(driver);
		ContactsPage cp=new ContactsPage(driver);
		//lp.clickOnLeadsContactButton();
		cp.clickOnCreateContactButton();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.getDataFromExcel("Contacts", 2, 1);
		String lName=eUtil.getDataFromExcel("Contacts", 2, 2);
		String leadSource=eUtil.getDataFromExcel("Contacts", 2, 3);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(fName, lName, leadSource);
		System.out.println("Test Execution Ended");
		
	}
}
