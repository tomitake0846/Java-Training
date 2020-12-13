package ch06.ex11;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Simulator s = new Simulator();
		s.run();
		ForkJoinPool.commonPool().awaitQuiescence(100, TimeUnit.SECONDS);
	}

}
