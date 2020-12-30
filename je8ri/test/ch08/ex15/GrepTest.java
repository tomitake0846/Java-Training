package ch08.ex15;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.regex.PatternSyntaxException;

import org.junit.jupiter.api.Test;

class GrepTest {

	@Test
	void invalidRegexTest() {
		assertThrows(PatternSyntaxException.class, () -> Grep.grep(null,"./test/ch08/ex15/test/sample1"));
		assertThrows(PatternSyntaxException.class, () -> Grep.grep("[]","./test/ch08/ex15/test/sample1"));

		assertThrows(PatternSyntaxException.class, () -> Grep.grep(null,"./test/ch08/ex15/test/sample1",System.out::println));
		assertThrows(PatternSyntaxException.class, () -> Grep.grep("[]","./test/ch08/ex15/test/sample1",System.out::println));
	}
	@Test
	void invalidPathTest() {
		assertThrows(InvalidPathException.class, () -> Grep.grep("",null));
		assertThrows(InvalidPathException.class, () -> Grep.grep("","t"));

		assertThrows(InvalidPathException.class, () -> Grep.grep("",null,s -> {}));
		assertThrows(InvalidPathException.class, () -> Grep.grep("","t",s -> {}));
	}

	@Test
	void grepWithFileTest() throws IOException {
		Grep.grep("000-0000 sample","./test/ch08/ex15/test/sample1",(s) -> {
			assertEquals("000-0000 sample",s);
		});

		Grep.grep("faild test","./test/ch08/ex15/test/sample1",(s) -> {
			fail("should't exist text 'faild test'");
		});
	}

	@Test
	void grepWithDirectoryTest() throws IOException {
		int count[] = {0};
		Grep.grep("flag\\{t0mmy\\}","./test/ch08/ex15/test/",(s) -> {
			assertTrue(s.contains("flag{t0mmy}"));
			count[0]++;
		});
		assertEquals(2,count[0]);

		Grep.grep("faild test","./test/ch08/ex15/test/",(s) -> {
			fail("should't exist text 'faild test'");
		});
	}
}
