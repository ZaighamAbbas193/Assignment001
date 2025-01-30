package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	public Properties properties;

	public PropertiesReader(String filePath) {
		properties = new Properties();
		try (InputStream input = new FileInputStream(filePath)) {
			// Load the properties file
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
