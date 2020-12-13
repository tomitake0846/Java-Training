package ch09.ex05;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileLoaderTest {

	/*read test*/

	@Test
	void normal1() throws IOException {
		byte[] bytes = FileLoader.read("test/ch09/ex05/test");
		assertEquals(5,bytes.length);
	}

	@Test
	void normal2() throws IOException {
		byte[] bytes = FileLoader.read("test/ch09/ex05/test2");
		assertEquals(15,bytes.length);
	}

	@Test
	void abnormal() {
		assertThrows(IOException.class , () -> FileLoader.read(""));
	}

	/*reverse test*/

	@Test
	void normal3() throws IOException {
		byte[] bytes = FileLoader.read("test/ch09/ex05/test");
		byte[] reversed = FileLoader.reverse(bytes);
		assertEquals(5,reversed.length);

		for(int i=0;i<bytes.length;i++) {
			assertEquals(bytes[i],reversed[reversed.length - (i+1)]);
		}
	}

	@Test
	void normal4() throws IOException {
		byte[] bytes = FileLoader.read("test/ch09/ex05/test2");
		byte[] reversed = FileLoader.reverse(bytes);
		assertEquals(15,reversed.length);

		for(int i=0;i<bytes.length;i++) {
			assertEquals(bytes[i],reversed[reversed.length - (i+1)]);
		}
	}

	@Test
	void abnormal2() {
		assertThrows(NullPointerException.class , () -> FileLoader.reverse(null));
	}

	/*write test*/

	@Test
	void normal5() throws IOException {
		byte[] bytes = FileLoader.read("test/ch09/ex05/test");
		FileLoader.write(FileLoader.reverse(bytes), "test/ch09/ex05/test3");
		assertDoesNotThrow(() -> FileLoader.read("test/ch09/ex05/test3"));
	}

	@Test
	void abnormal3() {
		assertThrows(IOException.class , () -> FileLoader.write(new byte[1],""));
	}
}
