package ch02.ex11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void toStringTest() {
		LinkedList list = new LinkedList();
		assertEquals(list.toString(),"[]");
		list.add(0);
		list.add(1);
		list.add(2);
		assertEquals(list.toString(),"[0,1,2,]");
	}

}
