package ch09.ex07;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.jupiter.api.Test;

class HTMLReaderTest {

	@Test
	void readExceptionTest() {
		assertThrows(IOException.class, () -> HTMLReader.readURL(""));
	}
	@Test
	void copyExceptionTest() throws IOException {
		InputStream in = HTMLReader.readURL("https://www.wakhok.ac.jp/biblion/1996/JavaAppli/node19.html");
		assertThrows(IOException.class, () -> HTMLReader.copy(in, ""));
	}

	@Test
	void copyTest() throws IOException {
		InputStream in = HTMLReader.readURL("https://www.wakhok.ac.jp/biblion/1996/JavaAppli/node19.html");
		assertDoesNotThrow(() -> HTMLReader.copy(in, "test/ch09/ex07/test",StandardCopyOption.
				REPLACE_EXISTING));
		assertTrue(Files.exists(Paths.get("test/ch09/ex07/test")));
	}
}
