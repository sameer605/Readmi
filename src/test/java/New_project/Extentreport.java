package New_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreport {
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@Test
	
	public void verifyBlogTitle ()
	{
		report =new ExtentReports ("D:\\sameer\\ReportofRun.html");
		logger=report.startTest("This is title of the report");
		
		System.setProperty("webdriver.chrome.driver","D:\\selenium jars\\chrome 87\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO,"Browserstarted");
		driver.get("http://www.orangehrm.com/");
		logger.log(LogStatus.INFO, "site launch successfully");
		String title=driver.getTitle();
		System.out.println("Title of webpage is "+title);
		Assert.assertTrue(title.contains("HR Management Software"));
		logger.log(LogStatus.INFO,"title checking done");
		
	}
	
	@AfterMethod
	public void tearDown (ITestResult result)
	{
	if (result.getStatus()==ITestResult.FAILURE)
	{
		logger.log(LogStatus.FAIL,"title verification is failed");
	}
	report.endTest(logger);
	report.flush();
	driver.get("D:\\sameer\\ReportofRun.html");
		
	}
	

}
