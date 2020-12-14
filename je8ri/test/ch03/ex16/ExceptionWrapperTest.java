package ch03.ex16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionWrapperTest {

	@Test
	void normalTest01() {
		ExceptionWrapper.doInOrderAsync(
				() -> {
					return 1;
				},
				(e,v) -> {
					if(v == null) {
						assertEquals(1,e);
						return;
					} else {
						fail();
					}
					fail();
				});
	}

	@Test
	void abnormalTest01() {
		ExceptionWrapper.doInOrderAsync(
				() -> {
					throw new RuntimeException();
				},
				(e,v) -> {
					if(v == null) {
						fail();
					} else {
						assertEquals(RuntimeException.class,v.getClass());
						return;
					}
					fail();
				});
	}
}
