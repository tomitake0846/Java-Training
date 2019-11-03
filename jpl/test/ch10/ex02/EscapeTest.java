package ch10.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EscapeTest {

	private Escape e = new Escape();

	@Test
	void newlineTest() {
		String raw = "Hello\nWorld";
		String expect = "Hello\\nWorld";
		assertEquals(expect,e.escape(raw));
	}
	@Test
	void tabTest() {
		String raw = "Hello\tWorld";
		String expect = "Hello\\tWorld";
		assertEquals(expect,e.escape(raw));
	}
	@Test
	void backspaceTest() {
		String raw = "Hello\bWorld";
		String expect = "Hello\\bWorld";
		assertEquals(expect,e.escape(raw));
	}
	@Test
	void returnTest() {
		String raw = "Hello\rWorld";
		String expect = "Hello\\rWorld";
		assertEquals(expect,e.escape(raw));
	}
	@Test
	void formfieldTest() {
		String raw = "Hello\fWorld";
		String expect = "Hello\\fWorld";
		assertEquals(expect,e.escape(raw));
	}

	@Test
	void singlequoteTest() {
		String raw = "<script>alert('XSS')</script>";
		String expect = "<script>alert(\\\'XSS\\\')</script>";
		assertEquals(expect,e.escape(raw));
	}

	@Test
	void doublequoteTest() {
		String raw = "<script>alert(" + '"' + "XSS" + '"' + ")</script>";
		String expect = "<script>alert(\\\"XSS\\\")</script>";
		assertEquals(expect,e.escape(raw));
	}

	@Test
	void slashTest() {
		String raw = "\\";
		String expect = "\\\\";
		assertEquals(expect,e.escape(raw));
	}

	@Test
	void asciiTest() {
		String raw = "\012";
		String expect = "\\n";
		assertEquals(expect,e.escape(raw));
	}
}
