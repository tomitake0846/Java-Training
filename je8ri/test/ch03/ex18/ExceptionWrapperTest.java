package ch03.ex18;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionWrapperTest {

	@Test
	void test1() {
		assertThrows(RuntimeException.class,() -> {
			ExceptionWrapper.unchecked((s) -> {
				throw new Exception();
			}).apply(1);
		});
	}

	@Test
	void test2() {
		assertEquals(1,ExceptionWrapper.unchecked((s) -> s).apply(1));
	}

}
