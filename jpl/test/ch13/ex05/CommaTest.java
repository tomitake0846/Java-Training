package ch13.ex05;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class CommaTest {

	@Test
	void test() {

		Comma c = new Comma();

		assertEquals("123",c.transrate("123"));
		assertEquals("1,234",c.transrate("1234"));
		assertEquals("12,345",c.transrate("12345"));
		assertEquals("123,456",c.transrate("123456"));
		assertEquals("1,234,567",c.transrate("1234567"));

	}

}
