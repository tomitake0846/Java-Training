package ch02.ex13;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortWordCounter {
	public Map<Integer,Long> count(Stream<String> stream) {
		return stream.filter(e -> e.length() < 12)
			.collect(Collectors.groupingBy(String::length,Collectors.counting()));
	}
}
