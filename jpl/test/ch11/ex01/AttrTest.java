package ch11.ex01;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import ch11.ex02.Attr;

class AttrTest {

	@Test
	void ConstructorTest1() {

		Attr<Integer> intAttr = new Attr<Integer>("test");

		intAttr.setValue(100);

		assertTrue(intAttr.getValue() instanceof Integer);
		assertEquals(100,(int)intAttr.getValue());
	}

	@Test
	void ConstructorTest2() {
		Attr<String> strAttr = new Attr<String>("hoge","foo");

		assertEquals("foo",strAttr.getValue());

		assertEquals("foo",strAttr.setValue("bar"));
		assertEquals("bar",strAttr.getValue());

	}
}
