package ch05.ex02;

import java.time.LocalDate;

public class PlusYearTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2000, 2, 29);

		// ( add a year )
		System.out.println(date.plusYears(1));

		// ( add 4 year )
		System.out.println(date.plusYears(4));

		LocalDate dummy = LocalDate.of(2020, 2, 29);

		// ( add a year) * 4
		for(int i=0;i<4;i++) {
			dummy = dummy.plusYears(1);
		}

		System.out.println(dummy);
	}
}
