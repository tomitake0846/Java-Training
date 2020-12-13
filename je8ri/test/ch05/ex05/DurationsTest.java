package ch05.ex05;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DurationsTest {

	@Test
	void test() {

		LocalDate from = LocalDate.now();
		LocalDate to = from.minusDays(1);

		assertEquals(1,Durations.daysDuration(from, to));
	}

	@Test
	void test2() {
		LocalDate from = LocalDate.now();
		LocalDate to = from.plusDays(1);

		assertEquals(1,Durations.daysDuration(from, to));
	}

}
