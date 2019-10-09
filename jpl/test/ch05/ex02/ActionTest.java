package ch05.ex02;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class ActionTest {

	@Test
	void Immutabletest() {

		Action a1 = new Action();
		a1.setAction("draw");
		Action a2 = new Action(a1);
		a1.setAction("deposit");

		assertFalse(a1.getAction().equals(a2.getAction()));

		assertEquals("draw",a2.getAction());

	}

}
