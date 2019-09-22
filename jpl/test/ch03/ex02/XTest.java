package ch03.ex02;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class XTest {

	@Test
	void maskTest() {
		X x = new X();
		assertEquals(0x0011,x.mask(0x1111));
	}

}
