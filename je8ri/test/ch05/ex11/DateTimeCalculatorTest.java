package ch05.ex11;

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

		ZonedDateTime dtLos = ZonedDateTime.of(LocalDateTime.of(2000,1,1,16,40,0),los);
		ZonedDateTime dtFrank = ZonedDateTime.of(LocalDateTime.of(2000,1,1,14,5,0),frank);

		LocalTime requiredTime = DateTimeCalculator.requiredTime(dtFrank, dtLos);

		//unknown
//		assertEquals(99999999,requiredTime.getHour());
		assertEquals(35,requiredTime.getMinute());

	}

}
