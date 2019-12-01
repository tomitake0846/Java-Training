package ch12.ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void test() {
		LinkedList list = new LinkedList();

		assertThrows(ObjectNotFoundException.class,()-> list.find(0));

		list.add(1);
		list.add(2);
		list.add(3);

		LinkedList expected = new LinkedList();
		expected.add(1);
		try {
			assertEquals(expected.get(1),list.find(1).get(1));
		} catch (ObjectNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		assertThrows(ObjectNotFoundException.class,()-> list.find(0));

	}

}
