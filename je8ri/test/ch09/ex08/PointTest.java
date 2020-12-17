package ch09.ex08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void equalsTest() {
		Point p1 = new Point(0,0);
		assertEquals(0,p1.compareTo(p1));
	}
	@Test
	void XTest() {
		Point p1 = new Point(1,0);
		Point p2 = new Point(0,1);
		assertEquals(1,p1.compareTo(p2));
		assertEquals(-1,p2.compareTo(p1));
	}

	@Test
	void YTest() {
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,0);
		assertEquals(1,p1.compareTo(p2));
		assertEquals(-1,p2.compareTo(p1));
	}

}
