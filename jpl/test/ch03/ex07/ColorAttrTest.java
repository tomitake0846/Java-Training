package ch03.ex07;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class ColorAttrTest {

	@Test
	void equalsTest() {
		ScreenColor c1 = new ScreenColor("nice black");
		ColorAttr attr1 = new ColorAttr("test",c1);
		ColorAttr attr2 = new ColorAttr("test",c1);
		ColorAttr attr3 = new ColorAttr("test",new ScreenColor("nice black"));
		ColorAttr attr4 = new ColorAttr("test",new ScreenColor("good white"));
		assertFalse(attr1.equals(null));
		assertFalse(attr1.equals(1));
		assertTrue(attr1.equals(attr1));
		assertTrue(attr1.equals(attr2));
		assertTrue(attr1.equals(attr3));
		assertFalse(attr1.equals(attr4));
	}

	@Test
	void hashcodeTest() {
		ScreenColor c1 = new ScreenColor("nice black");
		ColorAttr attr1 = new ColorAttr("test",c1);
		ColorAttr attr2 = new ColorAttr("test",c1);
		ColorAttr attr3 = new ColorAttr("test",new ScreenColor("nice black"));
		ColorAttr attr4 = new ColorAttr("test",new ScreenColor("good white"));
		assertTrue(attr1.hashCode() == attr1.hashCode());
		assertTrue(attr1.hashCode() == attr2.hashCode());
		assertFalse(attr1.hashCode() == attr3.hashCode());
		assertFalse(attr1.hashCode() == attr4.hashCode());
	}
}
