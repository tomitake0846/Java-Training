package ch05.ex09;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class TimezoneFilter {
	public List<LocalDateTime>  getOffset() {

		return ZoneId.getAvailableZoneIds().stream()
			.map(id -> LocalDateTime.now(ZoneId.of(id)))
			.filter(date -> {
				long s = Duration.between(date, LocalDateTime.now(ZoneOffset.UTC)).getSeconds();
				s = Math.abs(s);
				return s < 60 * 60;
			})
			.collect(Collectors.toList());
	}

}
