package ch08.ex15;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Regex {
	public static boolean matches(String target,String regexStr) {
		return Pattern.compile(regexStr).asPredicate().test(target);
	}

	public static boolean valid(String regexStr){
		if(regexStr == null) {
			return false;
		}
		try {
			Pattern.compile(regexStr);
			return true;
		} catch (PatternSyntaxException e) {
			return false;
		}
	}
}