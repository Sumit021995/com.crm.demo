package TC_Repo;

import org.testng.annotations.Test;

import PomClassesRepo.CreatingNewLeadPage;
import PomClassesRepo.HomePage;
import PomClassesRepo.LeadsPage;
import genericUtility.BaseClass;
import genericUtility.ExcelUtility;

public class TC_002 extends BaseClass
{
	@Test
	public void leads_002() throws Exception
	{
		System.out.println("Test Execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnLeadsContactButton();
		
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.getDataFromExcel("Leads", 5, 1);
		String lName=eUtil.getDataFromExcel("Leads", 5, 2);
		String company=eUtil.getDataFromExcel("Leads", 5, 3);
		String phone=eUtil.getDataFromExcel("Leads", 5, 4);
		String website=eUtil.getDataFromExcel("Leads", 5, 5);
	
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fName, lName,company, phone, website);
		System.out.println("Test Execution Ended");
	}

}
