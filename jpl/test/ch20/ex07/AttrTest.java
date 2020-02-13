package ch20.ex07;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class AttrTest {

	@Test
	void test() throws IOException {
		Attr attr = new Attr("foo","bar");
		File file = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch20\\ex07\\test.txt");
		attr.writeAttr(file.getAbsolutePath());

		attr = new Attr(file);

		assertEquals("foo",attr.getName());
		assertEquals("bar",attr.getValue());
	}

}
