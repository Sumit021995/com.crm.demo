package genericUtility;


//import java.io.ObjectInputFilter.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener in TestNG and will monitor the execution
 * @author Sumit Saurav
 * @version 24.11.07
 */
public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	JavaUtility jUtil=new JavaUtility();
	String dateTimeStamp=jUtil.getCalanderDetails("dd-MM-YYYY hh-mm-ss");
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" execution started");
		
		//create a test
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" execution passed");
		
		test.log(Status.PASS , methodName+" execution passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" execution failed");
		
		test.log(Status.FAIL, methodName+" execution failed");
		
		//capturing the screenshot of test script getting failed and attaching to report
		
		SeleniumUtility sUtil=new SeleniumUtility();
		String screenshotName=methodName+dateTimeStamp;
		try {
			String path=sUtil.getWebPageScreenshot(BaseClass.sDriver, screenshotName);
			
			test.addScreenCaptureFromPath(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+" execution skipped");
		
		test.log(Status.SKIP, methodName+" execution skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
		//configuration of the report
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(".\\Extent Reports\\Report-"+dateTimeStamp+".html");
		reporter.config().setDocumentTitle("VTiger Testing Reports");
		reporter.config().setReportName("VTiger");
		reporter.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(reporter);		//generate the report
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Reporter Name", "Sumit Saurav");
		report.setSystemInfo("Test Engineer", "Sumit Saurav");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		
		report.flush();		//generate the report
	}

	
}
/**
 * 
 
 
package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
*/
/**
 * This class provides implementation to ITestListener in TestNG and will monitor the execution.
 * @author Sumit Saurav
 * @version 24.11.07
 */
/*
public class ListenersImplementation implements ITestListener {

    ExtentReports report;
    ExtentTest test;
    JavaUtility jUtil = new JavaUtility();
    String dateTimeStamp = jUtil.getCalanderDetails("dd-MM-yyyy hh-mm-ss");

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " execution started");

        // Create a test in the Extent Report
        test = report.createTest(methodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " execution passed");

        // Log the test as PASSED in the Extent Report
        test.log(Status.PASS, methodName + " execution passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " execution failed");

        // Log the test as FAILED in the Extent Report
        test.log(Status.FAIL, methodName + " execution failed");

        // Capture the screenshot of the failed test and attach it to the report
        SeleniumUtility sUtil = new SeleniumUtility();
        String screenshotName = methodName + "_" + dateTimeStamp;
        try {
            String path = sUtil.getWebPageScreenshot(BaseClass.sDriver, screenshotName);
            test.addScreenCaptureFromPath(path); // Attach the screenshot to the report
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " execution skipped");

        // Log the test as SKIPPED in the Extent Report
        test.log(Status.SKIP, methodName + " execution skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is intentionally left empty as it is not used.
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // This method is intentionally left empty as it is not used.
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Suite execution started");

        // Configuration of the Extent Report
        ExtentSparkReporter reporter = new ExtentSparkReporter(".\\ExtentReports\\Report_" + dateTimeStamp + ".html");
        reporter.config().setDocumentTitle("VTiger Testing Reports");
        reporter.config().setReportName("VTiger");
        reporter.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(reporter); // Attach the reporter to the ExtentReports instance

        // Set system information for the report
        report.setSystemInfo("Base URL", "http://localhost:8888");
        report.setSystemInfo("Base OS", "Windows");
        report.setSystemInfo("Base Browser", "Chrome");
        report.setSystemInfo("Reporter Name", "Sumit Saurav");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Suite execution finished");

        // Flush the report to generate it
        report.flush();
    }
}

 */