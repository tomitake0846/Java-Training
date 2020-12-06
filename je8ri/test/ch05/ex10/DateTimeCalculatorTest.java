package ch05.ex10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

class DateTimeCalculatorTest {

	@Test
	void test() {
		ZoneId los = ZoneId.of("America/Los_Angeles");
		ZoneId frank = ZoneId.of("Europe/Berlin");
		ZonedDateTime departureDateTime = ZonedDateTime
				.of(LocalDateTime.of(2000,1,1,3,5,0),los);
		LocalTime requiredTime = LocalTime.of(10,50,0);
		ZonedDateTime ldt =	DateTimeCalculator.
				arrivedTime(departureDateTime,requiredTime,frank);


		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		// los utc-8
		// Frankfurt utc + 1
		// time difference 9
		// 03:05:00 + 10:50:00 = 13:55:00 (Los_Angeles)
		// ldt's timezone is Frankfrut
		assertEquals(13,ldt.getHour() - 9);
		assertEquals(55,ldt.getMinute());
	}
}
