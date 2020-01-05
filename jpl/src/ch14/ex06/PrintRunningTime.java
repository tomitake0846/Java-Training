package ch14.ex06;

public class PrintRunningTime extends Thread{

	private long startTime;

	private SaySomething[] threads;

	public PrintRunningTime(SaySomething...threads ) {
		this.startTime = System.currentTimeMillis();
		this.threads = threads;
	}

	public synchronized void run() {
		threadStart();
		int passagingTime =0;
		while(true) {
			if(PassagingASecond()) {
				threadAwake();
				passagingTime++;
				System.out.println("passaging " +passagingTime + " second...");
			}
		}
	}

	private boolean PassagingASecond() {
		long currentTime = System.currentTimeMillis();

		if((currentTime - startTime) >= 1000) {
			startTime = currentTime;
			return true;
		}
		return false;
	}

	private void threadStart() {
		for(SaySomething t : threads) {
			t.start();
		}
	}
	private void threadAwake() {
		for(SaySomething t : threads ) {
			t.awake();
		}
	}

}
