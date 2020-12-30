package ch08.ex15;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class FileLoaderTest {

	@Test
	void readTest() throws IOException {
		Path path = Paths.get("./test/ch08/ex15/test/sample1");
		List<String> list = FileLoader.read(path).collect(Collectors.toList());

		assertEquals(3,list.size());
		assertEquals("000-0000 sample",list.get(0));
		assertEquals("0000-0000",list.get(1));
		assertEquals("000-000 test",list.get(2));
	}

}
