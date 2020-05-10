package ch24.ex02;

import java.util.Currency;
import java.util.Locale;

public class PrintCurrencySynbol {

	public static void main(String[] args) {
		print(Locale.JAPAN);
		print(Locale.CHINA);
		print(Locale.TAIWAN);
		print(Locale.FRANCE);
		print(Locale.ITALY);
		print(Locale.UK);
	}

	public static void print(Locale locale) {
		Currency c = Currency.getInstance(locale);
		System.out.println(locale + " : " + c.getSymbol(locale));
	}
}
