package ch09.ex09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LabeledPointTest {

	@Test
	void toStringTest() {
		LabeledPoint lp = new LabeledPoint(0,0);
		assertEquals("label:[] :(0,0)", lp.toString());

		lp.labeled("origin");
		assertEquals("label:[origin] :(0,0)", lp.toString());
	}

	@Test
	void hashCodeEqualsTest() {
		LabeledPoint lp1 = new LabeledPoint(0,0);
		LabeledPoint lp2 = new LabeledPoint(0,0);
		assertTrue(lp1.hashCode() == lp2.hashCode());

		lp1.labeled("origin");
		lp2.labeled("origin");
		assertTrue(lp1.hashCode() == lp2.hashCode());
	}

	@Test
	void hashCodeNotEqualsTest() {
		//addition & production test
		LabeledPoint lp1 = new LabeledPoint(1,0);
		LabeledPoint lp2 = new LabeledPoint(0,1);
		assertTrue(lp1.hashCode() != lp2.hashCode());

		//subtraction test
		lp1 = new LabeledPoint(3,1);
		lp2 = new LabeledPoint(2,0);
		assertTrue(lp1.hashCode() != lp2.hashCode());


		//division test
		lp1 = new LabeledPoint(3,1);
		lp2 = new LabeledPoint(6,2);
		assertTrue(lp1.hashCode() != lp2.hashCode());

		//label test
		lp1 = new LabeledPoint(0,0);
		lp2 = new LabeledPoint(0,0);
		lp1.labeled("test");
		assertTrue(lp1.hashCode() != lp2.hashCode());
	}
}
