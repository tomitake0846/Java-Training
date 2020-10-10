package ch02.ex12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ShortWordCount {
	public AtomicInteger[] count(Stream<String> stream) {

		AtomicInteger[] ary = initAIArray(12);

		stream.filter(e -> e.length() < 12)
			.parallel()
			.forEach(e -> ary[e.length()].getAndIncrement());

		return ary;
	}
	private AtomicInteger[] initAIArray(int size) {
		AtomicInteger[] ary = new AtomicInteger[size];
		for(int i=0;i<ary.length;i++) {
			ary[i] = new AtomicInteger(0);
		}
		return ary;
	}
}
