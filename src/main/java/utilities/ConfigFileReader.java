package utilities;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
	public static String getConfigValueFromPropertyFile(String parameter) {
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

	public static String getConfigValueFromEnvFile(String parameter) {
		Dotenv dotenv = Dotenv.load();
		return dotenv.get(parameter);
	}
}
