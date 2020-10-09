package ch02.ex12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		ShortWordCount c = new ShortWordCount();
		Stream<String> s = Stream.of("1","22","333","4444","55555","55555","11111111111","not count string:::::");
		for(AtomicInteger ai : c.count(s)) {
			System.out.println(ai.get());
		}

	}
}
