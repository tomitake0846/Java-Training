package ch03.ex18;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionWrapper {
	public static <T> Supplier<T> unchecked(Callable<T> f) {
		return () -> {
			try {
				return f.call();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} catch (Throwable t) {
				throw t;
			}
		};
	}

	public static <T,R> Function<T,R> unchecked(MyFunction<T,R> f) {
		return (t) -> {
			try {
				return f.apply(t);
			}  catch (Exception e) {
				throw new RuntimeException(e);
			} catch (Throwable x) {
				throw x;
			}
		};
	}

	public void test() {
		//ok
		unchecked((s) ->{
			throw new Exception();
		});
	}

}
