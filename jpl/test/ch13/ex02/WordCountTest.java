package ch13.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordCountTest {

	@Test
	void test() {

		WordCount counter = new WordCount();
		String targetString = "foobarfogefoge";

		assertEquals(-1,counter.count(null,"foo"));
		assertEquals(-1,counter.count(targetString,null));
		assertEquals(-1,counter.count(targetString,""));
		assertEquals(0,counter.count("","foo"));

		assertEquals(4,counter.count(targetString, "o"));
		assertEquals(3,counter.count(targetString, "fo"));

		targetString = "bababababa";
		String targetWord = "aba";
		//b[aba]bababa
		//bab[aba]baba
		//babab[aba]ba
		//bababab[aba]
		assertEquals(4,counter.count(targetString, targetWord));

		targetWord = "abab";
		//b[abab]ababa
		//bab[abab]aba
		//babab[abab]a
		assertEquals(3,counter.count(targetString, targetWord));
	}

}
