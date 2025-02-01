package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import objectRepo.CreateLeadsPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_001 extends BaseClass
{
	@Test
	public void leads_001() throws Exception
	{
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadMenuBtn();
	
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadsPlusIcon();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Leads", 2, 1);
		String lName=eUtil.fetchingDataFromExcelFile("Leads", 2, 2);
		String company=eUtil.fetchingDataFromExcelFile("Leads", 2, 3);
		CreateLeadsPage cnlp=new CreateLeadsPage(driver);
		cnlp.createLeadOperation(fName,lName,company);
		System.out.println("Test Execution Ended");
	}
}
