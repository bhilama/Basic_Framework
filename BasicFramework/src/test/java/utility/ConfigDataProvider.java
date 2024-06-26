package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	private Properties prop;
	
	public ConfigDataProvider() {
	
		
				
		try {
			File src = new File("./config/Config.properties");
			FileInputStream fin = new FileInputStream(src);	
			prop = new Properties();
			prop.load(fin);
		}
		catch(IOException e) {
			System.out.println("Unable to read config file - " + e.getMessage());
		}
	}
	
	public String getConfigData(String key) {
		return prop.getProperty(key).trim();
	}
}
