package ch05.ex07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import ch05.ex07.TimeInterval;

class TimeIntervalDuplicateTest {
	@Test
	/*
	 * from :              |----|
	 *
	 * to   :  |----|
	 * -----------------------------
	 * from :  |----|
	 *
	 * to   :              |----|
	 * */
	void notDuplicate1() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,2,0,0),LocalDateTime.of(2000,1,1,3,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,1,1,0,0));

		assertFalse(from.isDuplicated(to));
		assertFalse(to.isDuplicated(from));
	}

	@Test
	/*
	 * from :  |----|
	 *
	 * to   :       |----|
	 * ------------------------------
	 * from :       |----|
	 *
	 * to   :  |----|
	 * */
	void notDuplicate2() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,1,1,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,1,0,0),LocalDateTime.of(2000,1,1,2,0,0));

		assertFalse(from.isDuplicated(to));
		assertFalse(to.isDuplicated(from));
	}

	@Test
	/*
	 * from :  |----|
	 *         **duplicated**
	 * to   :     |----|
	 * -----------------------------
	 * from :     |----|
	 *         **duplicated**
	 * to   :  |----|
	 * */
	void duplicate1_overMinutes() {
		//00:00:00 ~ 01:00:00
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,1,1,0,0));

		//00:30:00 ~ 01:30:00
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,0,30,0),LocalDateTime.of(2000,1,1,1,30,0));
		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate1_overHours() {
		//09:00:00 ~ 12:00:00
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,9,0,0),LocalDateTime.of(2000,1,1,12,0,0));

		//10:00:00 ~ 15:00:00
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,10,0,0),LocalDateTime.of(2000,1,1,15,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate1_overDays() {
		//2000-01-01 ~ 2000-01-14
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,14,0,0,0));

		//2000-01-10 ~ 2000-01-24
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,10,0,0,0),LocalDateTime.of(2000,1,24,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate1_overMonths() {
		//2020-01-01 ~ 2020-07-01
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,7,1,0,0,0));

		//2020-04-01 ~ 2020-09-01
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,4,1,0,0,0),LocalDateTime.of(2000,9,1,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate1_overYears() {
		//2000 ~ 2002
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2002,1,1,0,0,0));

		//2001 ~ 2002
		TimeInterval to = new TimeInterval(LocalDateTime.of(2001,1,1,0,0,0),LocalDateTime.of(2003,1,1,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}

	@Test
	/*
	 * from :  |----------|
	 *         **duplicated**
	 * to   :     |----|
	 * ----------------------------
	 * from :    |------|
	 *         **duplicated**
	 * to   : |-------------|
	 * */
	void duplicate2_minute() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,1,0,0),LocalDateTime.of(2000,1,1,1,55,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,1,10,0),LocalDateTime.of(2000,1,1,1,30,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate2_hour() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,9,0,0),LocalDateTime.of(2000,1,1,18,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,10,0,0),LocalDateTime.of(2000,1,1,11,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate2_day() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,30,0,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,2,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate2_month() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,7,1,0,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,4,1,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate2_year() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2003,1,1,0,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2001,1,1,0,0,0),LocalDateTime.of(2002,1,1,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
	@Test
	void duplicate2_EqualsFromValue() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,30,0,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,2,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}

	@Test
	void duplicate2_EqualsToValue() {
		TimeInterval from = new TimeInterval(LocalDateTime.of(2000,1,1,0,0,0),LocalDateTime.of(2000,1,30,0,0,0));
		TimeInterval to = new TimeInterval(LocalDateTime.of(2000,1,4,0,0,0),LocalDateTime.of(2000,1,30,0,0,0));

		assertTrue(from.isDuplicated(to));
		assertTrue(to.isDuplicated(from));
	}
}
