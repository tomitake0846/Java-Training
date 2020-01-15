package ch14.ex02;

import java.awt.PrintJob;

public class PrintServer implements Runnable{

	private final PrintQueue requests = new PrintQueue();
	private final String WORKER = "worker thread";

	public PrintServer() {
		Thread thread = new Thread(this);
		thread.setName(WORKER);

		//another case
		//Thread thread = new Thread(this,WORKER);

		thread.start();
	}
	public void print(PrintJob job) {
		requests.add(job);
	}

	@Override
	public void run() {
		if(isWorkerThread(Thread.currentThread())) {
			for(;;) {
				//println for debug
				System.out.println("running!");
				try {
					realPrint(requests.remove());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			//println for debug
			throw new RuntimeException("Illegal call run method.");
		}
	}

	private void realPrint(PrintJob job) {
		//印刷処理
	}

	private boolean isWorkerThread(Thread thread) {
		return this.WORKER.equals(thread.getName());
	}
}
