package ch03.ex17;

import org.junit.jupiter.api.Test;

class ExceptionWrapperTest {

	@Test
	void test() {
		ExceptionWrapper.doInParallelAsync(
				() -> {
					throw new RuntimeException("exception1");
				},
				() -> {
					throw new RuntimeException("exception2");
				},
				(e) -> {
					System.out.println(e);
				});
	}
}
