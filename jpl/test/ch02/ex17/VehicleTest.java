package ch02.ex17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void AngleTest_intType() {
		Vehicle v = new Vehicle("test");

		assertEquals(0,v.getAngle());

		v.turn(360);
		assertEquals(0,v.getAngle());

		v.turn(180);
		v.turn(-180);
		assertEquals(0,v.getAngle());

		v.turn(20);
		assertEquals(20,v.getAngle());

		v.turn(-10);
		assertEquals(10,v.getAngle());

		v.turn(-20);
		assertEquals(350,v.getAngle());
	}

	@Test
	void angleTest_AngleType() {
		Vehicle v = new Vehicle("test");

		v.turn(Vehicle.TURN_LEFT);
		assertEquals(270,v.getAngle());

		v.turn(Vehicle.TURN_RIGHT);
		assertEquals(0,v.getAngle());

	}
}
