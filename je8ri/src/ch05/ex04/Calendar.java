package ch05.ex04;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {

	public static void main(String[] args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("invalid number of argument.");
		}
		String year = args[1];
		String month = args[0];

		LocalDate date = toDate(year,month);
		String[] result = shape(date);

		for(String str : result) {
			System.out.println(str);
		}
	}

	private static String[] shape(LocalDate date) {
		StringBuilder sb = new StringBuilder();
		LocalDate dummy = date;

		//init
		sb.append(padding(date));

		do {
			String day = String.format("%2d", dummy.getDayOfMonth());
			sb.append(" ");
			sb.append(day);

			if(dummy.getDayOfWeek() == DayOfWeek.SUNDAY) {
				sb.append(",");
			}

			dummy = dummy.plusDays(1);

		} while (dummy.getMonth().equals(date.getMonth()));

		return sb.toString().split(",");
	}

	private static String padding(LocalDate date) {
		int paddingCount = date.getDayOfWeek().getValue() - 1;
		StringBuilder sb = new StringBuilder();
		String padding = "   ";
		for(int i=0; i<paddingCount; i++) {
			sb.append(padding);
		}
		return sb.toString();
	}

	private static LocalDate toDate(String year , String month) {
		try {
			int y = Integer.parseInt(year);
			int m = Integer.parseInt(month);

			return LocalDate.of(y, m, 1);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("argument type is not integer.");
		} catch (DateTimeException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
