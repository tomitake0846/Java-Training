package ch03.ex08;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class PassengerVehicleTest {

	@Test
	void cloneTest() {
		Vehicle v = new Vehicle();
		v.changeSpeed(30);
		v.setAngle(100);
		v.setOwner("test");
		Vehicle clone = (Vehicle) v.clone();

		assertTrue(v.getSpeed() == clone.getSpeed());
		assertTrue(v.getAngle() == clone.getAngle());
		assertFalse(v.getOwner().equals(clone.getOwner()));
		assertFalse(v.getId() == clone.getId());

	}

}
