package ch05.ex10;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeCalculator {
	public static ZonedDateTime arrivedTime(ZonedDateTime departureDateTime, LocalTime requiredTime , ZoneId arriveTimeZone) {
		long x = departureDateTime.toInstant().getEpochSecond() + requiredTime.toSecondOfDay();
		return Instant.ofEpochSecond(x).atZone(arriveTimeZone);
	}

}
