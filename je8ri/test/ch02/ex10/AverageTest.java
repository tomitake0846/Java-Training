package ch02.ex10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class AverageTest {

	@Test
	void test() {
		Stream<Double> stream = Stream.of(0.0);
		Average a = new Average();
		assertEquals(0.0,a.getAverage(stream));
	}

	@Test
	void test2() {
		Average a = new Average();
		assertThrows(NullPointerException.class, () -> a.getAverage(null));
	}

	@Test
	void test3() {
		Stream<Double> stream = Stream.of(1.0,2.0,3.0);
		Average a = new Average();
		assertEquals(2.0,a.getAverage(stream));
	}
}
