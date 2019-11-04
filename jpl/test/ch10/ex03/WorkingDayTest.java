package ch10.ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorkingDayTest {

	WorkingDay w = new WorkingDay();

	@Test
	void ifTest() {
		assertTrue(w.isWorkingDay1(WeekDay.MONDAY));
		assertTrue(w.isWorkingDay1(WeekDay.THUESDAY));
		assertTrue(w.isWorkingDay1(WeekDay.WEDNESDAY));
		assertTrue(w.isWorkingDay1(WeekDay.THURSDAY));
		assertTrue(w.isWorkingDay1(WeekDay.FRIDAY));
		assertFalse(w.isWorkingDay1(WeekDay.SUTARDAY));
		assertFalse(w.isWorkingDay1(WeekDay.SUNDAY));
	}

	@Test
	void switchTest() {
		assertTrue(w.isWorkingDay2(WeekDay.MONDAY));
		assertTrue(w.isWorkingDay2(WeekDay.THUESDAY));
		assertTrue(w.isWorkingDay2(WeekDay.WEDNESDAY));
		assertTrue(w.isWorkingDay2(WeekDay.THURSDAY));
		assertTrue(w.isWorkingDay2(WeekDay.FRIDAY));
		assertFalse(w.isWorkingDay2(WeekDay.SUTARDAY));
		assertFalse(w.isWorkingDay2(WeekDay.SUNDAY));
	}
}
