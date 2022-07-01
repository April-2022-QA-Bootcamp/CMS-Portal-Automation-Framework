package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	private static ReadConfigFile readConfigFile;
	private static String location = "./configuration/configure.properties";

	private static String url;
	private static int pageLoadTime;
	private static int implicitlyWaitTime;

	private ReadConfigFile() {

	}
	
	public static ReadConfigFile getInstance() {
		if(readConfigFile == null) {
			readConfigFile = new ReadConfigFile();
			readProperties();
		}		
		return readConfigFile;
		
	}

	private static void readProperties() {
		try {
			FileReader reader = new FileReader(location);
			Properties properties = new Properties();
			properties.load(reader);
			//Top 3 lines are reading the configure.properties file
			url = properties.getProperty("url");
			pageLoadTime = Integer.parseInt(properties.getProperty("pageLoadTime"));
			implicitlyWaitTime = Integer.parseInt(properties.getProperty("implicitlyWaitTime"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getImplicitlyWaitTime() {
		return implicitlyWaitTime;
	}

	public static String getUrl() {
		return url;
	}

	public static int getPageLoadTime() {
		return pageLoadTime;
	}

	

}
