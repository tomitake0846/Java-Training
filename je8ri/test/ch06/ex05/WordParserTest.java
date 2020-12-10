package ch06.ex05;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class WordParserTest {

	@Test
	void normalTest() throws IOException {
		WordParser wp = new WordParser();

		assertEquals(3, wp.parseToWordList(new File("./test/ch06/ex05/test")).size());
	}

	@Test
	void emptyFileTest() throws IOException {
		WordParser wp = new WordParser();

		assertEquals(0, wp.parseToWordList(new File("./test/ch06/ex05/test3")).size());
	}

	@Test
	void exceptionTest() {
		WordParser wp = new WordParser();
		assertThrows(IOException.class, () -> wp.parseToWordList(new File("")));
	}

}
