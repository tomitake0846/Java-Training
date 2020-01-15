package ch14.ex06;

public abstract class SaySomething extends Thread{

	public abstract boolean GoodCondition();

	public synchronized void awake() {
		notifyAll();
	}
}
