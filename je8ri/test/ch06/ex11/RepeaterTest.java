package ch06.ex11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RepeaterTest {

	@Test
	void test() {
		int[] i= {0};
		Repeater.repeat(() -> i[0]++, (t) -> t==10000)
		.thenAccept(ans -> assertEquals(10000,ans));

	}
}
