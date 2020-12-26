package ch08.ex07;

import static java.util.Comparator.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ReversedTest {

	@Test
	void test() {
		String[] ary1 = generate();
		String[] ary2 = generate();
		String[] ary3 = generate();
		String[] ary4 = generate();

		Arrays.sort(ary1,comparing(String::toString,nullsFirst(naturalOrder())).reversed());
		Arrays.sort(ary2,comparing(String::toString,nullsFirst(reverseOrder())));
		Arrays.sort(ary3,comparing(String::toString,(s1,s2) -> s2.compareTo(s1)));
		Arrays.sort(ary4,comparing(String::toString,(s1,s2) -> -s1.compareTo(s2)));

		assertEquals(Arrays.toString(ary1),Arrays.toString(ary2));
		assertEquals(Arrays.toString(ary1),Arrays.toString(ary3));
		assertEquals(Arrays.toString(ary1),Arrays.toString(ary4));
	}

	private String[] generate() {
		String[] ary = {"apple","orange","grape","pineapple","drian"};
		return ary;
	}

}
