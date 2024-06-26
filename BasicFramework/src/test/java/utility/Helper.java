package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
			
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + getCurrentDateTime() + ".png";
		
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot - " + e.getMessage());
		}
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
}
