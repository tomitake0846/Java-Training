package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ExceptionWrapper {
	public static <T> void doInOrderAsync(Supplier<T> first,BiConsumer<T,Throwable> second) {

		//It's not smart implementation.
		//Is there any other good implementation?
		Thread thread = new Thread(() -> {
			T result = null;
			Throwable e = null;
			try {
				result = first.get();
			} catch (Throwable t) {
				e = t;
			} finally {
				second.accept(result, e);
			}
		});

		thread.start();
	}
}
