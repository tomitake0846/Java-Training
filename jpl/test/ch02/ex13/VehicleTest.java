package ch02.ex13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void speedTest() {

		Vehicle v = new Vehicle("test");

		assertEquals((float)0.0,v.getSpeed());

		v.setSpeed((float) 10.0);

		assertEquals((float)10.0,v.getSpeed());

		v.setSpeed((float) -10.0);

		assertEquals((float)0.0,v.getSpeed());
	}

	@Test
	void angleTest() {

		Vehicle v = new Vehicle("test");

		assertEquals(0,v.getAngle());

		v.setAngle(90);

		assertEquals(90,v.getAngle());

		v.setAngle(-100);

		assertEquals(0,v.getAngle());

		v.setAngle(400);

		assertEquals(40,v.getAngle());

	}
	@Test
	void ownerTest() {
		Vehicle v = new Vehicle("test");

		assertEquals("test",v.getOwner());

		v.setOwner("test2");

		assertEquals("test2",v.getOwner());
	}
}
