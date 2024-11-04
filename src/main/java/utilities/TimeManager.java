package utilities;

import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeManager {
	private static final String TEMP_FILE = "target/execution_times.json";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	private static final DateTimeFormatter FULL_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void setStartTime() {
		LocalDateTime now = LocalDateTime.now();
		JSONObject times = new JSONObject();
		times.put("currentDate", now.format(DATE_FORMATTER));
		times.put("startTime", now.format(TIME_FORMATTER));
		times.put("fullStartTime", now.format(FULL_FORMATTER));
		writeTimesToFile(times);
	}

	public static void setEndTime() {
		try {
			File file = new File(TEMP_FILE);
			JSONObject times = new JSONObject(new String(Files.readAllBytes(file.toPath())));
			LocalDateTime now = LocalDateTime.now();

			times.put("endTime", now.format(TIME_FORMATTER));
			times.put("fullEndTime", now.format(FULL_FORMATTER));

			writeTimesToFile(times);
			calculateExecutionTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calculateExecutionTime() {
		try {
			File file = new File(TEMP_FILE);
			JSONObject times = new JSONObject(new String(Files.readAllBytes(file.toPath())));

			LocalDateTime startDate = LocalDateTime.parse(times.getString("fullStartTime"), FULL_FORMATTER);
			LocalDateTime endDate = LocalDateTime.parse(times.getString("fullEndTime"), FULL_FORMATTER);

			Duration duration = Duration.between(startDate, endDate);

			long hours = duration.toHours();
			long minutes = duration.toMinutesPart();
			long seconds = duration.toSecondsPart();

			String totalTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
			times.put("executionTime", totalTime);

			writeTimesToFile(times);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeTimesToFile(JSONObject times) {
		try {
			Files.write(new File(TEMP_FILE).toPath(), times.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
