package ch06.ex05;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

class WordCounterTest {

	@Test
	void singleTest() {
		WordCounter wc = new WordCounter();
		wc.set(new File("./test/ch06/ex05/test"));
		ConcurrentHashMap<String , Set<File>> counter = wc.start();

		assertEquals(3,counter.keySet().size());
		assertEquals(1,counter.get("test3").size());
	}

	@Test
	void duplicateTest() {
		WordCounter wc = new WordCounter();
		wc.set(new File("./test/ch06/ex05/test"));
		wc.set(new File("./test/ch06/ex05/test2"));
		ConcurrentHashMap<String , Set<File>> counter = wc.start();

		assertEquals(5,counter.keySet().size());

		assertEquals(1,counter.get("test5").size());
		assertEquals(2,counter.get("test3").size());
	}

}
