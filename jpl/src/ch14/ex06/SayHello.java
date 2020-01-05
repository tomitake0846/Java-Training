package ch14.ex06;

public class SayHello extends SaySomething{

	private long startTime;

	public SayHello() {
		this.startTime = System.currentTimeMillis();
	}

	public synchronized void run() {
		while(true) {
			sayHello();
		}
	}

	private synchronized void sayHello(){
		while(!GoodCondition()) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("Hello!");
	}

	@Override
	public boolean GoodCondition() {
		long currentTime = System.currentTimeMillis();
		if((currentTime - this.startTime) >= 15 * 1000) {
			this.startTime = currentTime;
			return true;
		}
		return false;
	}

}
