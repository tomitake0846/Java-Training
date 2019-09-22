package ch03.ex02;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class YTest {

	@Test
	void maskTest() {
		Y y = new Y();
		assertEquals(0x1111,y.mask(0x1111));
	}

}
