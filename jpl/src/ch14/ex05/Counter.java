package ch14.ex05;

public class Counter {
	private static int count = 0;

	public static void count () {
		synchronized(Counter.class) {
			count++;
			System.out.println("count :"+count);
		}
	}

	public void sub(int x) {
		synchronized(Counter.class) {
			count -= x;
			System.out.println("count :"+count);
		}
	}

}
