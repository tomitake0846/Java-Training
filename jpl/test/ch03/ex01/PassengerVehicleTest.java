package ch03.ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch03.ex01.PassengerVehicle;

class PassengerVehicleTest {

	@Test
	void sheetNumtest() {
		PassengerVehicle v = new PassengerVehicle(2);
		assertEquals(2,v.getSheetNum());

	}

	@Test
	void sheetNumExceptiontest() {
		assertThrows(IllegalArgumentException.class , ()-> new PassengerVehicle(0));
		assertThrows(IllegalArgumentException.class , ()-> new PassengerVehicle(-1));
	}

	@Test
	void rideTest() {
		PassengerVehicle v = new PassengerVehicle(2);
		assertTrue(v.ride());
		assertTrue(v.ride());
		assertFalse(v.ride());
	}
	@Test
	void getPassengersTest() {
		PassengerVehicle v = new PassengerVehicle(2);
		assertEquals(0,v.getPassengers());

		v.ride();
		assertEquals(1,v.getPassengers());

		v.ride();
		assertEquals(2,v.getPassengers());

		v.ride();
		assertEquals(2,v.getPassengers());
	}
}
