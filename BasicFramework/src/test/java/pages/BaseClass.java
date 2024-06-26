package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;

public class BaseClass {

	public WebDriver driver;
	String appURL = "https://www.freecrm.com/index.html";
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest log;
	
	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentSparkReporter spark = new ExtentSparkReporter(new File("./reports/CRM_"+ Helper.getCurrentDateTime() +  ".html")); 
		report = new ExtentReports();
		report.attachReporter(spark);
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getConfigData("Browser"), config.getConfigData("qaUrl"));
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			log.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			log.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
	}
}
