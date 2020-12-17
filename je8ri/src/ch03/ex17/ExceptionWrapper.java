package ch03.ex17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
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

	public static <T> void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		List<Future<?>> futureList = new ArrayList<>();
		ExecutorService pool = Executors.newFixedThreadPool(3);
		futureList.add(pool.submit(first));
		futureList.add(pool.submit(second));
		ForkJoinPool.commonPool().awaitQuiescence(10,TimeUnit.SECONDS);

		for(Future<?> f : futureList) {
			try {
				f.get();
			} catch (ExecutionException ee) {
				handler.accept(ee);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}
	}
}
