package ch05.ex08;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DifferentTimeAmongTimezones {
	public static void getOffset() {
		ZoneId.getAvailableZoneIds();

		ZoneId.getAvailableZoneIds().stream()
			.map(id -> LocalDateTime.now(ZoneId.of(id)))
			.map(date -> Duration.between(date, LocalDateTime.now(ZoneOffset.UTC)))
			.forEach(System.out::println);
	}

	public static void main(String[] args) {
		getOffset();
	}
}
