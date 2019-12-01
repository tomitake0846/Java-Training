package ch13.ex04;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.jupiter.api.Test;

class TransraterTest {

	@Test
	void intTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Transrater t = new Transrater();
		String input = "Integer 1";
		List list = t.run(input);

		assertEquals(1,list.get(0));
	}
	void doubleTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Transrater t = new Transrater();
		String input = "Double 3.14";
		List list = t.run(input);

		assertEquals(3.14,list.get(0));
	}

	void stringTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Transrater t = new Transrater();
		String input = "String test";
		List list = t.run(input);

		assertEquals("test",list.get(0));
	}
	void multipleLineTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Transrater t = new Transrater();
		String input = "Integer 1\nDouble 3.14\nString test";
		List list = t.run(input);

		assertEquals(3,list.size());
		assertEquals(1,list.get(0));
		assertEquals(3.14,list.get(1));
		assertEquals("test",list.get(2));
	}
}
