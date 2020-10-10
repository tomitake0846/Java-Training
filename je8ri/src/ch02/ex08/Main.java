package ch02.ex08;

import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Stream<String> first = Stream.of("1","2","3","4");
		Stream<String> second = Stream.of("10","20","30","40");

		Zip.zip(first, second).forEach(System.out::println);

	}
}
