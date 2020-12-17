package ch09.ex11;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class InputStreamFilterTest {

	@Test
	void abnormalest() throws IOException{
		File file = new File("test/ch09/ex11/InputStreamFilterTestText");
		FileInputStream isr = new FileInputStream(file);

		assertThrows(NullPointerException.class, () -> InputStreamFilter.read(null,(s) -> true));
		assertThrows(NullPointerException.class, () -> InputStreamFilter.read(new FileInputStream(file),null));

		InputStreamFilter.read(isr, (s) -> true);
		assertThrows(IOException.class, () -> InputStreamFilter.read(isr, (s) -> true));
	}

	@Test
	void readTest() throws IOException {
		File file = new File("test/ch09/ex11/InputStreamFilterTestText");

		assertEquals(4,InputStreamFilter.read(new FileInputStream(file), (s) -> true).size());
		assertEquals(0,InputStreamFilter.read(new FileInputStream(file), (s) -> false).size());
		assertEquals(3,InputStreamFilter.read(new FileInputStream(file), (s) -> s.matches("test")).size());
	}

}
