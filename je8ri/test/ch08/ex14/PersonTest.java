package ch08.ex14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void test() {
		assertThrows(NullPointerException.class,() -> new Person(null));
		showErrorMessage(() -> new Person(null));
	}

	void showErrorMessage(Runnable r) {
		try {
			r.run();
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}

}
