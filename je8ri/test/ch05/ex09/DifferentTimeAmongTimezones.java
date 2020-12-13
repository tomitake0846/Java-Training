package ch05.ex09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

class DifferentTimeAmongTimezones {

	@Test
	void test() {
		TimezoneFilter dtt = new TimezoneFilter();

		for(LocalDateTime ldt : dtt.getOffset()) {
			long s = Duration.between(ldt, LocalDateTime.now(ZoneOffset.UTC)).getSeconds();
			assertTrue(s < 60*60);
		}
	}

}
