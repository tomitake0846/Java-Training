package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;

public class Durations {
	public static long daysDuration(LocalDate from, LocalDate to) {
		long term = ChronoUnit.DAYS.between(from, to);
		if(term < 0) {
			return term * -1;
		} else {
			return term;
		}
	}

	public static long numberOfMyLivingPeriod(BiFunction<LocalDate,LocalDate,Long> func) {
		LocalDate from = LocalDate.of(1994,01,19);
		LocalDate to = LocalDate.now();

		return func.apply(from, to);
	}
}
