package ch08.ex04;

import java.util.Random;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		Stream.generate(() -> r.nextDouble())
			.limit(1_000_000)
			.mapToDouble(d -> d)
			.min()
			.ifPresent(System.out::println);
	}

}
