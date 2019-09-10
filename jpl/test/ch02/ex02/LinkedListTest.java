package ch02.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	public void addAndGetNodeTest() {
		LinkedList list = new LinkedList();
		list.add(10);
		assertNotNull(list.getNode(1));
		list.add(20);
		assertNotNull(list.getNode(2));
		list.add(30);
		assertNotNull(list.getNode(3));

		assertNull(list.getNode(4));
		assertNull(list.getNode(-1));
	}
	@Test
	public void getValueTest() {
		LinkedList list = new LinkedList();
		list.add(10);
		assertEquals(list.getNode(1).getValue() , 10);
		list.add(20);
		assertEquals(list.getNode(2).getValue() , 20);
	}

}
