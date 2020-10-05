package ch01.ex06;

import java.util.concurrent.Callable;

public interface RunnableEx {
	public void run() throws Exception;
	public static Runnable uncheck(RunnableEx runner) {

		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
	//callableでも行けた
	public static Callable<Void> uncheck(Callable<Void> runner) {
		return () -> {
			try {
				runner.call();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return null;
		};
	}
}
