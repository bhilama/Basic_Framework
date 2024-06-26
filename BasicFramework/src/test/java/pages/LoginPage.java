package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(name = "email")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(css = ".ui.fluid.large.blue.submit.button")
	WebElement loginButton;
	
	
	public void loginToCRM(String user, String pwd) {
		userName.sendKeys(user);
		password.sendKeys(pwd);
		loginButton.click();
	}
}
