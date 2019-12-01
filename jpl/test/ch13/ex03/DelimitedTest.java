package ch13.ex03;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch13.ex03.Delimited;

class DelimitedTest {

	@Test
	void test1() {
		String target = "<p>Hello</p>";
		char start = '<';
		char end = '>';

		String[] result = Delimited.delimitedString(target, start, end);
		assertEquals(2,Delimited.delimitedString(target, start, end).length);
		System.out.println(Arrays.toString(result));
	}

	@Test
	void test2() {
		String target = "'> < ";
		char start = '<';
		char end = '>';

		String[] result = Delimited.delimitedString(target, start, end);
		System.out.println(Arrays.toString(result));
		assertEquals(1,Delimited.delimitedString(target, start, end).length);
	}

	@Test
	void test3() {
		String target = "88888888";
		char start = '8';
		char end = '8';

		String[] result = Delimited.delimitedString(target, start, end);
		System.out.println(Arrays.toString(result));
		assertEquals(4,Delimited.delimitedString(target, start, end).length);
	}

	@Test
	void test4() {
		String target = "<<HU>GA>";
		char start = '<';
		char end = '>';

		String[] result = Delimited.delimitedString(target, start, end);
		System.out.println(Arrays.toString(result));
		assertEquals(1,Delimited.delimitedString(target, start, end).length);
	}

}
