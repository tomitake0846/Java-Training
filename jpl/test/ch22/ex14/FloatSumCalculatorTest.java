package ch22.ex14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FloatSumCalculatorTest {

	@Test
	void test() {
		FloatSumCalculator fsc = new FloatSumCalculator();

		assertEquals(123.4f,fsc.sum("123.4"));
		assertEquals(123f,fsc.sum("123"));
		assertEquals(223.9f,fsc.sum("123.4 100.5"));
		assertEquals(273.9f,fsc.sum("123.4 100.5 50"));
		assertThrows(NumberFormatException.class,() -> fsc.sum("test"));
		assertThrows(NumberFormatException.class,() -> fsc.sum("123 test"));
	}

}
