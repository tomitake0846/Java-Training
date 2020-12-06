package ch05.ex06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch05.ex06.EnumThirteensFriday;

class EnumThirteensFridayTest {

	@Test
	void test() {
		EnumThirteensFriday etf = new EnumThirteensFriday();
		List<LocalDate> list13Fridays = etf.enumThirteensFriday();
		for(LocalDate ld : list13Fridays) {
			assertEquals(13,ld.getDayOfMonth());
			assertEquals(DayOfWeek.FRIDAY,ld.getDayOfWeek());
		}
	}

}
