package ch09.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BitCounterTest {

	@Test
	void test() {
		BitCounter counter = new BitCounter();

		assertEquals(1,counter.BitCount(1));//0b0001 -> 1
		assertEquals(1,counter.BitCount(2));//0b0010 -> 1
		assertEquals(3,counter.BitCount(7));//0b0111 -> 3
		assertEquals(3,counter.BitCount(13));//0b1101 -> 3
		assertEquals(2,counter.BitCount(12));//0b1010 -> 2
		assertEquals(31,counter.BitCount(-1));//0b1111 1111 1111 1111 1111 , 1111 1111 1111 1111 ->31
		assertEquals(31,counter.BitCount(Integer.MAX_VALUE));//0b0111 1111 1111 1111 1111 , 1111 1111 1111 1111 ->31
		assertEquals(0,counter.BitCount(0));//0b0000 -> 0
	}

}
