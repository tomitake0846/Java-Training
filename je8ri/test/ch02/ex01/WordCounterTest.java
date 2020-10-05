package ch02.ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordCounterTest {

	@Test
	void zeroTest() {
		WordCounter wc = new WordCounter();
		String[] ary = {};
		assertEquals(0,wc.count(ary));

	}

	@Test
	void countTest() {
		WordCounter wc = new WordCounter();
		String[] ary = {
				"development",
				"administration",
				"operation",
				"cloudEngineer"
			};
		assertEquals(2,wc.count(ary));
	}

}
