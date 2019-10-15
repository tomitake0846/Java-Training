package ch06.ex05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch06.ex04.Color;
import ch06.ex04.TrafficLight;

class TrafficLightTest {

	@Test
	void YellowTest() {

		Color color = TrafficLight.YELLOW.getColor();
		assertTrue(color.r() == 255);
		assertTrue(color.g() == 241);
		assertTrue(color.b() == 0);
	}
	@Test
	void RedTest() {
		Color color = TrafficLight.RED.getColor();
		assertTrue(color.r() == 255);
		assertTrue(color.g() == 0);
		assertTrue(color.b() == 0);
	}
	@Test
	void GreenTest() {
		Color color = TrafficLight.GREEN.getColor();
		assertTrue(color.r() == 0);
		assertTrue(color.g() == 255);
		assertTrue(color.b() == 0);
	}

}
