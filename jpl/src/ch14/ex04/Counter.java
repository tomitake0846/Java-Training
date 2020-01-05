package ch14.ex04;

public class Counter {
	private static int count = 0;

	public static synchronized void count () {
		count++;
		System.out.println("count :"+count);
	}

	// which better?
//	public static void count() {
//		synchronized(Counter.class) {
//			count++;
//			System.out.println("count :" + count);
//
//		}
//	}
}
