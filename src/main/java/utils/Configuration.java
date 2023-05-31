package utils;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	static Properties properties;

	public static void loadProperties(Class classs) {
		try {
			properties = new Properties();
			InputStream iStream = classs.getClassLoader().getResourceAsStream("config.properties");
			properties.load(iStream);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static String getUrl() {
		return properties.getProperty("url");
	}
	
}
