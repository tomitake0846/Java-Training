package ch09.ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	private static final String INCLUDES_CARD_NUMBER = ".*[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}.*";
	private static final String CARD_REGEX = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";
	public static boolean isCreditCardFormat(String str) {
		try {
			return str.matches(INCLUDES_CARD_NUMBER);
		} catch (Throwable t){
			return false;
		}
	}

	public static List<String> extractCreditCardNumbers(String str) {
		List<String> creditCardNumberList = new ArrayList<>();
		String creditCardNumber;
		Pattern p = Pattern.compile(CARD_REGEX);
		Matcher m = p.matcher(str);

		while(m.find()) {
			creditCardNumber = m.group();
			creditCardNumberList.add(creditCardNumber);
		}

		return creditCardNumberList;
	}
}
