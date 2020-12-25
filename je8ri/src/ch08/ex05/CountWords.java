package ch08.ex05;

import java.util.List;
import java.util.function.Predicate;

public class CountWords {
	public static int count(List<String> list,Predicate<String> condition) {
		int count = 0;
		for(String str : list) {
			if(condition.test(str)) {
				count ++;
			}
		}
		return count;
	}
}
