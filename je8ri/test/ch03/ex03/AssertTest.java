package ch03.ex03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class AssertTest {

	@Test
	void AssertError() {

		Supplier<Boolean> test = () -> false;

		assertThrows(AssertionError.class, () ->
			Assert.assertion(true, test , "Assertion threw")
		);
	}

	@Test
	void runWithAssert() {
		Supplier<Boolean> test = () ->  {
			System.out.println("in supplier");
			return false;
		};

		assertThrows(AssertionError.class, () ->
			Assert.assertion(true, test , "Assertion threw")
		);
	}

	@Test
	void runWithoutAssert() {
		Supplier<Boolean> test = () ->  {
			System.out.println("in supplier");
			return false;
		};

		Assert.assertion(false, test, "test");
	}

	@Test
	void runWithAssert2() {
		Supplier<Boolean> test = () ->  {
			System.out.println("in supplier");
			return true;
		};

		Assert.assertion(true, test, "test");

	}

	@Test
	void runWithAssert3() {
		Supplier<Boolean> test = () ->  {
			System.out.println("in supplier");
			return true;
		};

		Assert.assertion(false, test, "test");

	}
}
