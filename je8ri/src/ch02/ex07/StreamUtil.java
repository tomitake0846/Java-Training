package ch02.ex07;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;

public class StreamUtil {

	//don't worked.
	public static void main(String[] args) {
		System.out.println(isFinite(Stream.generate(() -> 0)));
		System.out.println(isFinite(Stream.generate(() -> 0).limit(10)));
	}

	//5 seconds.
	private static final long timeout= 1000 * 5;

	@SuppressWarnings("unchecked")
	public static <T> boolean isFinite (Stream<T> stream) {

		try {

			FutureTask ft = new FutureTask(new threadTest( () -> stream.count() ));

			Thread thread = new Thread(ft);

			thread.join(timeout);

			//be not throwed InterruptedException
			// => thread.run() not finished
			// => stream is not finite.
			return false;

		} catch (InterruptedException e1){
			return true;
		}

	}
}

class threadTest implements Callable<Void> {

	private Runnable r;
	threadTest(Runnable r) {
		this.r = r;
	}

	@Override
	public Void call() throws InterruptedException {
		r.run();
		throw new InterruptedException();
	}

}
