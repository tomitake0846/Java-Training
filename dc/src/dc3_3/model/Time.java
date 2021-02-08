package dc3_3.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Time implements Information{

	private final DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");

	public String get() {
		return LocalDateTime.now().format(f);
	}
}
