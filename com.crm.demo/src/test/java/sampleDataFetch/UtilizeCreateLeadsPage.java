package sampleDataFetch;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;
import objectRepo.CreateLeadsPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class UtilizeCreateLeadsPage {
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		PropertiesUtility pUtility  = new PropertiesUtility();
		String URL = pUtility.getDataFromPropertiesFile("url");
		String UN = pUtility.getDataFromPropertiesFile("username");
		String PWD = pUtility.getDataFromPropertiesFile("password");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadMenuBtn();
		LeadsPage lep=new LeadsPage(driver);
		lep.clickOnCreateLeadsPlusIcon();
		ExcelUtility eUtility = new ExcelUtility();
		List<String> ls =eUtility.fetchingMultipleDataFromExcelFileForFixedRowCrm("Leads", 2, 1);
		CreateLeadsPage clp=new CreateLeadsPage(driver);
		String s1=ls.get(0);
		String s2=ls.get(1);
		String s3=ls.get(2);
		clp.createLeadOperation(s1,s2,s3);
		Thread.sleep(3000);
		
		
		
	}
}
