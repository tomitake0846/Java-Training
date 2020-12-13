package ch05.ex03;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ch05.ex03.CustomAdjuster;

class CustomAdjusterTest {

	@Test
	void test1() {
		LocalDate date = LocalDate.of(2018, 1, 1);
		date = date.with(CustomAdjuster.next( d -> true));
		assertEquals("2018-01-02" , date.toString());
	}

	@Test
	void test2() {
		LocalDate date = LocalDate.of(2018, 1, 1);
		date = date.with(CustomAdjuster.next( d -> d.getDayOfMonth() == 13));
		assertEquals("2018-01-13" , date.toString());
	}
}
