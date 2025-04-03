package tcRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;
import objectRepo.CreateOrganizationsPage;
import objectRepo.HomePage;
import objectRepo.OrganizationPage;
@Listeners(genericUtility.ListenersImplementation.class)
public class Test_007 extends BaseClass {
	@Test
	public void createOrg() throws InterruptedException
	{
		new HomePage(driver).getOrganizationIconLink().click();;
		
		new OrganizationPage(driver).getCreateOrgPlusIcon().click();
		
		int r = new JavaUtility().generateRandomNumber(3000);
		CreateOrganizationsPage org1 = new CreateOrganizationsPage(driver);
		org1.getOrgNameTextField().sendKeys("org"+r,Keys.TAB,Keys.TAB,"website"+r,Keys.TAB,"9818425197",Keys.TAB,Keys.TAB,"fax"+r);
		org1.getOtherphoneTextField().sendKeys("8080412793",Keys.TAB,""+r,Keys.TAB,"abc"+r+"@gmail.com",Keys.TAB,"otherAbc"+r+"@gmail.com","Owner"+r);
		org1.getSicCodeTextField().sendKeys("SicCode"+r);
		org1.getAnnualRevenueTextField().sendKeys("111"+r);
		org1.getBill_streetTextArea().sendKeys("Adress No:"+r);
		org1.getMemberPlusIcon().click();
		
		SeleniumUtility sUtil = new SeleniumUtility();
		sUtil.switchToNewWindow(driver);
		driver.findElement(By.id("search_txt")).sendKeys("org");
		driver.findElement(By.name("search")).click();
		

		driver.findElement(By.id("2")).click();
//		sUtil.waitForElementToBeVisible(driver, 10, orgele);
//		orgele.click();
		
		sUtil.acceptAlert(driver);
		
		sUtil.switchToNewWindow(driver);
		org1.getSaveBtn().click();
		
		String varifyText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(varifyText.contains("org"+r));
		Reporter.log("Validated True",true);
		
		
		
		
		
	}
}
