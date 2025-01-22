package objectRepo;

import org.testng.annotations.Test;

import objectRepo.*;
import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import objectRepo.CreateLeadsPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_002 extends BaseClass
{
	@Test
	public void leads_002() throws Exception
	{
		System.out.println("Test Execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadMenuBtn();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadsPlusIcon();
		
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Leads", 5, 1);
		String lName=eUtil.fetchingDataFromExcelFile("Leads", 5, 2);
		String phone=eUtil.fetchingDataFromExcelFile("Leads", 5, 3);
		String noOfEmployee=eUtil.fetchingDataFromExcelFile("Leads", 5, 5);
		String country=eUtil.fetchingDataFromExcelFile("Leads", 5, 6);
		String city=eUtil.fetchingDataFromExcelFile("Leads", 5, 7);
		String state=eUtil.fetchingDataFromExcelFile("Leads", 5, 8);
		String website=eUtil.fetchingDataFromExcelFile("Leads", 5, 4);
	
		CreateLeadsPage cnlp=new CreateLeadsPage(driver);
		cnlp.createLeadOperation(fName,lName, phone, website,noOfEmployee,country, city, state);
		System.out.println("Test Execution Ended");
	}

}
