package ch06.ex04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AccumulatorTest {

	@Test
	void maxTest() {
		int n=10000;
		List<Integer> list = new ArrayList<>(n);
		for(int i=0;i<n; i++) {
			list.add((int) (Math.random()*Integer.MAX_VALUE));
		}

		Accumulator a = new Accumulator(Math::max,0);

		long streamMax = list.stream().mapToLong(i->i).max().getAsLong();
		long accumulatorMax = a.get(list);

		assertEquals(streamMax,accumulatorMax);
	}
	@Test
	void minTest() {
		int n=10000;
		List<Integer> list = new ArrayList<>(n);
		for(int i=0;i<n; i++) {
			list.add((int) (Math.random()*Integer.MIN_VALUE));
		}

		Accumulator a = new Accumulator(Math::min,0);

		long streamMax = list.stream().mapToLong(i->i).min().getAsLong();
		long accumulatorMax = a.get(list);

		assertEquals(streamMax,accumulatorMax);
	}
}
