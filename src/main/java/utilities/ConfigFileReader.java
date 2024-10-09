package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
	public static String getConfigValue(String parameter) {
		try {
			FileInputStream file = new FileInputStream("./config/config.properties");
			Properties property = new Properties();
			property.load(file);
			return property.get(parameter).toString().toLowerCase();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw (new RuntimeException("[ERROR] - Parameter with name '" + parameter + "' does not exists"));
		}
	}
}
