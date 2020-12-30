package ch08.ex05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CountWordsTest {

	@Test
	void test() {
		List<String> list = new ArrayList<>();
		assertEquals(0,CountWords.count(list, (s) -> true));

		list.add("test");
		assertEquals(1,CountWords.count(list, (s) -> s.length() > 3));
		assertEquals(0,CountWords.count(list, (s) -> s.length() > 5));
	}

	@Test
	void benchmark() {
		List<String> list = new ArrayList<>();
		for(int i=1;i<=10_000_000; i++) {
			list.add("" + i);
		}

		time(() -> {
			CountWords.count(list, (s) -> s.length() >= 6);
		});

		time(() -> {
			list.stream()
			.filter(s -> s.length() >= 6)
			.count();
		});

		time(() -> {
			list.parallelStream()
			.filter(s -> s.length() >= 6)
			.count();
		});
	}

	private void time(Runnable r) {
		long start = System.currentTimeMillis();
		r.run();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
