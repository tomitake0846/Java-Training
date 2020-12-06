package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnumThirteensFriday {
	public List<LocalDate> enumThirteensFriday() {
		List<LocalDate> list = new ArrayList<>();

		LocalDate start = LocalDate.of(1900, 1, 13);
		LocalDate dummy = start;
		do {
			if(dummy.getDayOfWeek() == DayOfWeek.FRIDAY) {
				list.add(dummy);
			}
			dummy = dummy.plusMonths(1);
		} while(dummy.getYear() < 2000);

		return list;
	}
}
