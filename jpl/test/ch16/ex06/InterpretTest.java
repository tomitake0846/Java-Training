package ch16.ex06;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class InterpretTest {

	@Test
	void test() {
		Interpret i = new Interpret("ch16.ex06.testClass");
		i.setField("i", 100);
		i.setField("str", "fugafuga");
		i.setField("t", new testClass());

		assertEquals(3,i.getFields().length);

		assertEquals(100,i.getFieldValue("i"));
		assertEquals("fugafuga",i.getFieldValue("str"));
		assertTrue(i.getFieldValue("t") instanceof testClass);


	}

}
class testClass {
	public int i;
	public String str;
	public testClass t;
}