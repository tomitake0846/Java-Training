package ch08.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NegateExactTest {

	@Test
	void test() {
		assertThrows(ArithmeticException.class,() -> Math.negateExact(2 << 31 -1));
	}

}
