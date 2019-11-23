package ch11.ex01;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void test() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		assertNull(list.get(-1));
		assertNull(list.get(0));
		assertNull(list.get(1));

		list.add(1);
		list.add(2);
		list.add(3);

		assertEquals(3,list.count());
		assertEquals(1,(int)list.get(1));
		assertEquals(2,(int)list.get(2));
		assertEquals(3,(int)list.get(3));


	}

}
