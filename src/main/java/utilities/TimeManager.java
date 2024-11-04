package utilities;

import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManager {
	private static final String TEMP_FILE = "target/execution_times.json";

	public static void setStartTime() {
		String startTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		writeTimesToFile("startTime", startTime);
	}

	public static void setEndTime() {
		String endTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		writeTimesToFile("endTime", endTime);
	}

	private static void writeTimesToFile(String timeType, String timeValue) {
		try {
			File file = new File(TEMP_FILE);
			JSONObject times = file.exists() ?
					new JSONObject(new String(Files.readAllBytes(file.toPath()))) :
					new JSONObject();
			times.put(timeType, timeValue);
			Files.write(file.toPath(), times.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
