package ch05.ex01;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ch05.ex01.ProgrammersDay;

class ProgrammersDayTest {

	//getProgrammersDay(int) test
	@Test
	void notLeapYearTest() {
		LocalDate date = ProgrammersDay.getProgrammersDay(2014);
		assertEquals(9,date.getMonth().getValue());
		assertEquals(13,date.getDayOfMonth());
	}

	@Test
	void LeapYearTest() {
		LocalDate date = ProgrammersDay.getProgrammersDay(2020);
		assertEquals(9,date.getMonth().getValue());
		assertEquals(12,date.getDayOfMonth());
	}

	@Test
	void IllegalValue_minus() {
		assertThrows(IllegalArgumentException.class , () -> ProgrammersDay.getProgrammersDay(-1));
	}

	//getProgrammersDayPractice(int) test
	@Test
	void notLeapYearTest_practice() {
		LocalDate date = ProgrammersDay.getProgrammersDayPractice(2014);
		assertEquals(9,date.getMonth().getValue());
		assertEquals(13,date.getDayOfMonth());
	}

	@Test
	void LeapYearTest_practice() {
		LocalDate date = ProgrammersDay.getProgrammersDayPractice(2020);
		assertEquals(9,date.getMonth().getValue());
		assertEquals(12,date.getDayOfMonth());
	}

	@Test
	void IllegalValue_minus_practice() {
		assertThrows(IllegalArgumentException.class , () -> ProgrammersDay.getProgrammersDayPractice(-1));
	}
}
