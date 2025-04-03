package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import objectRepo.CreateLeadsPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class Test_001 extends BaseClass
{
	@Test
	public void leads_001() throws Exception
	{
		int randomNumber = new JavaUtility().generateRandomNumber(10000);
		System.out.println("Test Exceution Started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadMenuBtn();
	
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadsPlusIcon();
	
		ExcelUtility eUtil=new ExcelUtility();
		String fName=eUtil.fetchingDataFromExcelFile("Leads", 2, 1)+randomNumber;
		String lName=eUtil.fetchingDataFromExcelFile("Leads", 2, 2)+randomNumber;
		String company=eUtil.fetchingDataFromExcelFile("Leads", 2, 3)+randomNumber;
		CreateLeadsPage cnlp=new CreateLeadsPage(driver);
		cnlp.createLeadOperation(fName,lName,company);
		System.out.println("Test Execution Ended");
	}
}
