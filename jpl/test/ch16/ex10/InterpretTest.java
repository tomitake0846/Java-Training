package ch16.ex10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InterpretTest {

	@Test
	void OneDimensionTest() {
		Interpret i = new Interpret();
		i.generateArray("java.lang.String", 2);
		i.setArrayElement("test0", 0);
		i.setArrayElement("test1", 1);
		assertEquals("test0",i.getArrayElement(0));
		assertEquals("test1",i.getArrayElement(1));

		i.prepareRunArrayElementMethod(0);
		assertEquals("test0",i.runArrayElementFunction("toString"));
	}

	@Test
	void TwoDimensionTest() {
		Interpret i = new Interpret();
		i.generateArray("java.lang.String", 2,2);
		i.setArrayElement("test00", 0,0);
		i.setArrayElement("test01", 0,1);
		i.setArrayElement("test10", 1,0);
		i.setArrayElement("test11", 1,1);
		assertEquals("test00",i.getArrayElement(0,0));
		assertEquals("test01",i.getArrayElement(0,1));
		assertEquals("test10",i.getArrayElement(1,0));
		assertEquals("test11",i.getArrayElement(1,1));

		i.prepareRunArrayElementMethod(1,1);
		assertEquals("test11",i.runArrayElementFunction("toString"));
	}

}
