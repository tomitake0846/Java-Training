package ch21.ex07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class MyStackTest {

	@Test
	void constractorTest() {

		MyStack<Integer> stack = new MyStack<Integer>();
		assertEquals(0,stack.size());

		stack = new MyStack<Integer>(10);
		assertEquals(0,stack.size());

		assertThrows(IllegalArgumentException.class,() -> new MyStack<Integer>(-1));

	}

	@Test
	void emptyTest() {
		MyStack<Integer> stack = new MyStack<Integer>();
		assertTrue(stack.empty());

		stack.push(1);
		assertFalse(stack.empty());

		stack.pop();
		assertTrue(stack.empty());
	}

	@Test
	void sizeTest() {
		MyStack<Integer> stack = new MyStack<Integer>();
		assertEquals(0,stack.size());

		stack.push(1);
		assertEquals(1,stack.size());

		stack.pop();
		assertEquals(0,stack.size());
	}

	@Test
	void pushAndPeekTest() {
		MyStack<Integer> stack = new MyStack<Integer>();

		assertThrows(EmptyStackException.class,() -> stack.peek());

		stack.push(10);
		int val = stack.peek();
		assertEquals(1,stack.size());
		assertEquals(10,val);

		stack.push(20);
		val = stack.peek();
		assertEquals(2,stack.size());
		assertEquals(20,val);

	}

	@Test
	void popTest() {
		MyStack<Integer> stack = new MyStack<Integer>();

		stack.push(10);

		int val = stack.pop();
		assertEquals(0,stack.size());
		assertEquals(10,val);

		stack.push(20);
		stack.push(30);
		stack.push(40);
		assertEquals(3,stack.size());

		val = stack.pop();
		assertEquals(40,val);

		val = stack.pop();
		assertEquals(30,val);

		val = stack.pop();
		assertEquals(20,val);

		assertEquals(0,stack.size());

		assertThrows(EmptyStackException.class,() -> stack.peek());
	}

	@Test
	void searchTest() {
		MyStack<Integer> is = new MyStack<Integer>();
		MyStack<String> ss = new MyStack<String>();

		is.push(10);
		is.push(20);
		is.push(30);
		assertEquals(1,is.search(10));
		assertEquals(2,is.search(20));
		assertEquals(3,is.search(30));
		assertEquals(-1,is.search(40));

		ss.push("10");
		ss.push("20");
		ss.push("30");
		assertEquals(1,ss.search("10"));
		assertEquals(2,ss.search("20"));
		assertEquals(3,ss.search("30"));
		assertEquals(-1,ss.search("40"));
	}
}
