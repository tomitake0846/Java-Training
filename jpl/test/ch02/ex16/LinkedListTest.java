package ch02.ex16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void countTest() {
		LinkedList list = new LinkedList();
		assertEquals(0,list.count());

		list.add(1);
		assertEquals(1,list.count());

		list.add(2);
		list.add(3);
		assertEquals(3,list.count());
	}

}
