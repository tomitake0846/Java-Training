package ch05.ex01;

import java.time.LocalDate;

public class ProgrammersDay {
	public static LocalDate getProgrammersDay(int year) {
		if(year < 0) throw new IllegalArgumentException();
		return LocalDate.of(year, 1, 1).plusDays(255);
	}

	public static LocalDate getProgrammersDayPractice(int year) {
		if(year < 0) throw new IllegalArgumentException();
		LocalDate date = LocalDate.of(year, 9, 13);
		if(date.isLeapYear()) {
			date = date.minusDays(1);
		}
		return date;
	}
}
