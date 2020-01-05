package ch14.ex03;

public class Counter {
	private int count = 0;
	public synchronized void count () {
		count++;
		System.out.println("count :"+count);
	}
}
