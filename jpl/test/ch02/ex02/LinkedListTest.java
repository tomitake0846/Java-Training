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

		assertTrue(list.hasMoreElement());

		p(list);

		list.remove();

		p(list);

		assertFalse(list.hasMoreElement());
	}
	private void p(LinkedList list) {
		System.out.println(list.toString());
	}
}
