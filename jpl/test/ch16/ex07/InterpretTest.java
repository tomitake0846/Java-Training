package ch16.ex07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InterpretTest {

	@Test
	void test() {

		Interpret i = new Interpret("ch16.ex07.test");

		assertEquals(25,i.function("add",10,15));
		assertEquals(1,i.function("x"));

	}

}
class test {
	public int x() {
		return 1;
	}
	public int add(Integer x,Integer y) {
		return x+y;
	}
	public void printX(Integer x) {
		System.out.println("x :"+x);
	}
	public void print() {
		System.out.println("test");
	}
}