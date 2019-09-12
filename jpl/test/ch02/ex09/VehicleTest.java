package ch02.ex09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void getMaximumIdTest() {
		Vehicle v = new Vehicle("alice");
		assertEquals(Vehicle.getMaximumId(),0);

		v = new Vehicle("bob");
		assertEquals(Vehicle.getMaximumId(),1);

		v = new Vehicle("mike");
		assertEquals(Vehicle.getMaximumId(),2);
	}

}
