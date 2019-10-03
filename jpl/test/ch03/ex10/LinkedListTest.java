package ch03.ex10;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void cloneTest() {
		LinkedList original = new LinkedList();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		original.add(list) ;
		LinkedList clone = (LinkedList) original.clone();
		((ArrayList)clone.getValue(1)).remove(1);
		assertTrue(((ArrayList)original.getValue(1)).size() == ((ArrayList)clone.getValue(1)).size());
	}

}
