package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LaunchPage;
import pages.LoginPage;
import utility.BrowserFactory;

public class LoginTestCRM extends BaseClass{
	

	@Test
	public void loginApp() {
		
		log = report.createTest("Verify user is able to login to the app.");
		
		String user = excel.getStringData("Login", 0, 0).trim();
		String pwd = excel.getStringData("Login", 0, 1).trim();
		log.info("Login with username - " + user + " and password - " + pwd);
		
	
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		launchPage.navigateToLoginPage();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToCRM(user, pwd);
		
		//End Test Result
		log.pass("Login successfull.");
	}

}
