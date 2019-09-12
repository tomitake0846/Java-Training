package ch02.ex10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	void toStringTest() {
		Vehicle v = new Vehicle("alice");
		String expected = "owner : alice\nspeed : 0.0\nangle : 0\nid : 0\n";
		assertEquals(expected,v.toString());

		v = new Vehicle("bob");
		expected = "owner : bob\nspeed : 0.0\nangle : 0\nid : 1\n";
		assertEquals(expected,v.toString());

		v = new Vehicle("tom");
		expected = "owner : tom\nspeed : 0.0\nangle : 0\nid : 2\n";
		assertEquals(expected,v.toString());
	}

}
