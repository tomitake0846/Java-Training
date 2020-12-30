package ch08.ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EuclideanTest {

	@Test
	void exceptionalTest() {
//		assertThrows(AlithmaticException.class, () -> )
	}

	@Test
	void zeroDivision() {
		assertEquals(18,Euclidean.run(18, 0, (a,b) -> a%b));
		assertEquals(18,Euclidean.run(18, 0, (a,b) -> Math.floorMod(a, b)));
		assertEquals(18,Euclidean.run(18, 0, Euclidean::rem));
	}

	@Test
	void divideZero() {
		assertEquals(12,Euclidean.run(0, 12, (a,b) -> a%b));
		assertEquals(12,Euclidean.run(0, 12, (a,b) -> Math.floorMod(a, b)));
		assertEquals(12,Euclidean.run(0, 12, Euclidean::rem));
	}

	@Test
	void positiveTest() {
		assertEquals(6,Euclidean.run(18, 12, (a,b) -> a%b));
		assertEquals(6,Euclidean.run(18, 12, (a,b) -> Math.floorMod(a, b)));
		assertEquals(6,Euclidean.run(18, 12, Euclidean::rem));

	}

	@Test
	void negativeTest() {
		assertEquals(6,Euclidean.run(18, -12, (a,b) -> a%b));
		assertEquals(-6,Euclidean.run(18, -12, (a,b) -> Math.floorMod(a, b)));
		assertEquals(6,Euclidean.run(18, -12, Euclidean::rem));

		assertEquals(-21,Euclidean.run(1071, -1029, (a,b) -> a%b));
		assertEquals(-21,Euclidean.run(1071, -1029, (a,b) -> Math.floorMod(a, b)));
		assertEquals(21,Euclidean.run(1071, -1029, Euclidean::rem));

		assertEquals(-6,Euclidean.run(-18, 12, (a,b) -> a%b));
		assertEquals(6,Euclidean.run(-18, 12, (a,b) -> Math.floorMod(a, b)));
		assertEquals(6,Euclidean.run(-18, 12, Euclidean::rem));
	}

	@Test
	void alithmaticTest() {
		assertEquals(6,Euclidean.run(18, -12, (a,b) -> Math.abs(a%b)));
		assertEquals(6,Euclidean.run(18, -12, (a,b) -> Math.abs(Math.floorMod(a, b))));
		assertEquals(6,Euclidean.run(18, -12, Euclidean::rem));

		assertEquals(6,Euclidean.run(-18, 12, (a,b) -> Math.abs(a%b)));
		assertEquals(6,Euclidean.run(-18, 12, (a,b) -> Math.abs(Math.floorMod(a, b))));
		assertEquals(6,Euclidean.run(-18, 12, Euclidean::rem));
	}

}
