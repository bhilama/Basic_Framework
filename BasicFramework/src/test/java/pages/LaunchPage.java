package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaunchPage {

	WebDriver driver;
	
	public LaunchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//span[text()='Log In']")
	WebElement loginButton;
	
	
	public void navigateToLoginPage() {
		loginButton.click();
		
	}
}
