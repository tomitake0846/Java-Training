package ch03.ex05;

public abstract class Benchmark {
	public abstract void run();

	public void start() {
		long start = System.nanoTime();
		run();
		long end = System.nanoTime();

		System.out.println("duration :"+(end - start)/10000000.0);
		System.out.println("start time :" + start);
		System.out.println("end time :" + end);
	}

}
