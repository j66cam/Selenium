package utilities;

import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeManager {
	private static final String TEMP_FILE = "target/execution_times.json";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void setStartTime() {
		String startTime = LocalDateTime.now().format(FORMATTER);
		writeTimesToFile("startTime", startTime);
	}

	public static void setEndTime() {
		String endTime = LocalDateTime.now().format(FORMATTER);
		writeTimesToFile("endTime", endTime);
		calculateExecutionTime();
	}

	private static void calculateExecutionTime() {
		try {
			File file = new File(TEMP_FILE);
			JSONObject times = new JSONObject(new String(Files.readAllBytes(file.toPath())));

			LocalDateTime startDate = LocalDateTime.parse(times.getString("startTime"), FORMATTER);
			LocalDateTime endDate = LocalDateTime.parse(times.getString("endTime"), FORMATTER);

			Duration duration = Duration.between(startDate, endDate);

			long horas = duration.toHours();
			long minutos = duration.toMinutesPart();
			long segundos = duration.toSecondsPart();

			String tiempoTotal = String.format("%02d:%02d:%02d", horas, minutos, segundos);
			times.put("executionTime", tiempoTotal);

			Files.write(file.toPath(), times.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
