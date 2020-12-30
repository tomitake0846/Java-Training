package ch08.ex15;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class FileProcessorTest {

	@Test
	void test() throws IOException {
		Path path = Paths.get("./test/ch08/ex15/test/sample1");
		FileProcessor.run("000-0000 sample", path, (s) -> {
			assertEquals("000-0000 sample",s);
		});
	}

}
