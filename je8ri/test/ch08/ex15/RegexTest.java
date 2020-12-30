package ch08.ex15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegexTest {

	@Test
	void validPatternTest() {
		assertTrue(Regex.valid("^[0-9]{3}-[0-9]{4}$"));
	}
	@Test
	void invalidPatternTest() {
		assertFalse(Regex.valid("[]"));
		assertFalse(Regex.valid(null));
	}

	@Test
	void matches() {
		assertTrue(Regex.matches("123-4567","^[0-9]{3}-[0-9]{4}$"));
	}

	@Test
	void notMatches() {
		assertFalse(Regex.matches("1234-4567","^[0-9]{3}-[0-9]{4}$"));
	}

}
