package ch02.ex15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void changeSpeedTest() {
		Vehicle v = new Vehicle("test");

		assertEquals((float)0.0,v.getSpeed());

		v.changeSpeed((float) 10.0);

		assertEquals((float)10.0,v.getSpeed());

		v.changeSpeed((float) -10.0);

		assertEquals((float)0.0,v.getSpeed());
	}

	@Test
	void stopTest() {
		Vehicle v = new Vehicle("test");

		assertEquals((float)0.0,v.getSpeed());

		v.changeSpeed((float) 10.0);

		assertEquals((float)10.0,v.getSpeed());

		v.stop();

		assertEquals((float)0.0,v.getSpeed());
	}
}
