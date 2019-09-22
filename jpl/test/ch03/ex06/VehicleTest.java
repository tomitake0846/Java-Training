package ch03.ex06;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void StartWithGasTanktest() {
		Vehicle v = new Vehicle(new GasTank());
		assertFalse(v.start());
		((GasTank)v.getEnergy()).refill(100);
		assertTrue(v.start());
	}

	@Test
	void StartWithBatterytest() {
		Vehicle v = new Vehicle(new Battery());
		assertFalse(v.start());
		((Battery)v.getEnergy()).refill(100);
		assertTrue(v.start());
	}

}
