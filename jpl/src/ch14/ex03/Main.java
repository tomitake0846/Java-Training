package ch14.ex03;

public class Main extends Thread{

	private Counter counter;

	public Main(Counter counter) {
		this.counter = counter;
	}

	public static void main(String[] args) {
		Counter counter = new Counter();

		for(int i=0;i<100;i++) {
			new Main(counter).start();
		}

	}

	public void run() {
		counter.count();
	}
}
