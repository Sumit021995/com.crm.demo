package tcRepo;

import org.testng.annotations.Test;

import objectRepo.CreateLeadsPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
import genericUtility.BaseClass;
import genericUtility.ExcelUtility;

public class Test_003 extends BaseClass
{
	@Test
	public void leads_003() throws Exception
	{
		System.out.println("Test Execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadMenuBtn();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadsPlusIcon();
		
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Leads", 8, 1);
		String lName=eUtil.fetchingDataFromExcelFile("Leads", 8, 2);
//		String company=eUtil.fetchingDataFromExcelFile("Leads", 8, 3);
		String phone=eUtil.fetchingDataFromExcelFile("Leads", 8, 4);
		String website=eUtil.fetchingDataFromExcelFile("Leads", 8, 5);
//		String noOfEmployees=eUtil.fetchingDataFromExcelFile("Leads", 8, 6);
//		String country=eUtil.fetchingDataFromExcelFile("Leads", 8, 7);
//		String city=eUtil.fetchingDataFromExcelFile("Leads", 8, 8);
//		String state=eUtil.fetchingDataFromExcelFile("Leads", 8, 9);
	
		CreateLeadsPage cnlp=new CreateLeadsPage(driver);
		cnlp.createLeadOperation(fName, lName, phone, website);
		System.out.println("Test Execution Ended");
	}

}
