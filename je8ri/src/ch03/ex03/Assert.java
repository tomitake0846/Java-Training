package ch03.ex03;

import java.util.function.Supplier;

public interface Assert {
	public static void assertion(boolean enable , Supplier<Boolean> test, String message) throws AssertionError{
		if(enable) {
			if(test.get()) {
				return;
			} else {
				throw new AssertionError(message);
			}
		} else {
			test.get();
		}
	}
}
