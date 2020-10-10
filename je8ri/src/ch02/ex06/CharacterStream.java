package ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStream {
	public static Stream<Character> characterStream(String s) {

		//before
//		List<Character> result = new ArrayList<>();
//		for(char c : s.toCharArray()) {
//			result.add(c);
//		}
//		return result.stream();

		//after

		return IntStream.iterate(0, el -> el + 1)
		.limit(s.length())
		.map(s::charAt)
		.mapToObj(e -> (char)e);
	}
}
