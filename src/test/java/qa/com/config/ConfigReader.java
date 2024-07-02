package qa.com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;

	public ConfigReader() {
		properties = new Properties();
		String userDirectory = System.getProperty("user.dir");

		String filePath = userDirectory + "\\src\\test\\java\\qa\\com\\config\\config.properties";


		try (InputStream input = new FileInputStream(filePath)) {			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file.");
		}
	}

	public String getUrl() {
		return properties.getProperty("BaseURL");
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getUsername() {
		return properties.getProperty("userName");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}

	public String getInvalidPassword() {
		return properties.getProperty("wrongPassword");
	}
	
	public String getDevice() {
		return properties.getProperty("Device");
	}
	
	public String getHeadless() {
		return properties.getProperty("Headless");
	}
	
	public String getdbUserName() {
		return properties.getProperty("dbUsername");
	}
	
	public String getdbPassword() {
		return properties.getProperty("dbpassword");
	}
	
	public String getdbConnectionString() {
		return properties.getProperty("db_conURL");
	}

	
}