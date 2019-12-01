package ch13.ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CharCountTest {

	@Test
	void test() {

		CharCount counter = new CharCount();

		String targetString = "hogehoge";

		assertEquals(-1,counter.count(null, 'h'));
		assertEquals(0,counter.count("", 'h'));
		assertEquals(2,counter.count(targetString, 'h'));
		assertEquals(0,counter.count(targetString, 'f'));

	}

}
