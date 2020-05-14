package ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class PrintDate {

	public static void main(String[] args) {
		test(Locale.JAPAN,strToDate("19900101 00:00:00"));
		test(Locale.JAPAN,strToDate("1990/01/01 00:00:00"));
		test(Locale.JAPAN,strToDate("1990-01-01 00:00:00"));
	}

	private static Date strToDate(String target) {
		StrToDateParser parser = new StrToDateParser();
		if(parser.validDate(target)) {
			try {
				return parser.getDate(target);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	private static void test(Locale locale,Date date) {

		int[] styles = {DateFormat.FULL,DateFormat.LONG,DateFormat.MEDIUM,DateFormat.SHORT};

		for(int dateStyle : styles) {
			for(int timeStyle : styles) {
				print(DateFormat.getDateTimeInstance(dateStyle,timeStyle,locale) , date);
			}
		}
	}

	private static void print(DateFormat fmt,Date date) {
		 System.out.println(fmt.format(date));
	}
}
