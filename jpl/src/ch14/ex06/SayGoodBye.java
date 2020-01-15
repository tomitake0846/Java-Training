package ch14.ex06;

public class SayGoodBye extends SaySomething{

	private long startTime;

	public SayGoodBye() {
		this.startTime = System.currentTimeMillis();
	}

	public synchronized void run() {
		while(true) {
			sayGoodBye();
		}
	}

	private synchronized void sayGoodBye(){
		while(!GoodCondition()) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("GoodBye!");
	}

	@Override
	public boolean GoodCondition() {
		long currentTime = System.currentTimeMillis();
		if((currentTime - this.startTime) >= 7 * 1000) {
			this.startTime = currentTime;
			return true;
		}
		return false;
	}

}
