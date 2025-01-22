package TC_Repo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_001 extends BaseClass
{
	@Test
	public void leads_001() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
	
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnLeadsContactButton();
	
		ExcelUtility eUtil=new ExcelUtility();
		String lName=eUtil.getDataFromExcel("Leads", 2, 1);
		String company=eUtil.getDataFromExcel("Leads", 2, 2);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName,company);
		System.out.println("Test Execution Ended");
	}
}
