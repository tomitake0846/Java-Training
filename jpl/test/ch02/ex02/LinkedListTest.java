package ch02.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	// if number of LInkedList's elements equals 0 , return of hasMoreElements() expected false.
	public void test() {
		LinkedList list = new LinkedList();
		assertFalse(list.hasMoreElement());

		list.add(10);

		assertEquals(LinkedList.getNode(1).getValue() , 10);

		assertFalse(list.hasMoreElement());

		list.add(20);
		assertEquals(LinkedList.getNode(2).getValue() , 20);

		assertNull(LinkedList.getNode(3));
		assertNull(LinkedList.getNode(-1));

	}
}
