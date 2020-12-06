package ch05.ex07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import ch05.ex07.TimeInterval;

class TimeIntervalOtherTest {


	@Test
	void illegalArgument_equals() {
		assertThrows(IllegalArgumentException.class,
				() -> new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,1,0,0,0)));
	}

	@Test
	void illegalArgument_fromBiggerThanTo() {
		assertThrows(IllegalArgumentException.class,
				() -> new TimeInterval(LocalDateTime.of(2001,1,1,0,0,0),LocalDateTime.of(2000,1,1,0,0,0)));
	}

	@Test
	void equalsFalseTest() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,1,1,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2001,1,1,0,0,0));

		assertFalse(from.equals(null));
		assertFalse(from.equals(to));

	}

	@Test
	void equalsTrueTest() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,2,0,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,2,0,0,0));

		assertTrue(from.equals(from));
		assertTrue(from.equals(to));

	}
}
