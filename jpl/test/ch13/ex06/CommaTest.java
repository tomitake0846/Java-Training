package ch13.ex06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommaTest {

	@Test
	void test() {
		Comma c = new Comma();
		String target = "123456";

		assertEquals("123,456",c.transrate(target,3,","));
		assertEquals("12,3456",c.transrate(target,4,","));
		assertEquals("1-2-3-4-5-6",c.transrate(target,1,"-"));
		assertEquals("12foo34foo56",c.transrate(target,2,"foo"));
	}

}
