package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class CustomAdjuster {
	public static TemporalAdjuster next(Predicate<LocalDate> func) {
		return TemporalAdjusters.ofDateAdjuster( w -> {
			LocalDate result;

			do {
				result = w.plusDays(1);
			} while (!func.test(result));

			return result;
		});
	}
}
