package ch02.ex02;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String[] ary = {
				"testtest1",
				"testtest2",
				"testtest3",
				"testtest4",
				"testtest5",
				"testtest6",
				"testtest7",
				"testtest8",
				"testtest9",
				"testtest10",
				"testtest11",
				"testtest12",
				"testtest13",
				"testtest14",
				"testtest15"
		};
		System.out.println(ary.length);
		Arrays.stream(ary).
			filter(e -> e.length() >= 5).
			peek(System.out::println).
			limit(5).
			forEach(System.out::println);

	}
}
