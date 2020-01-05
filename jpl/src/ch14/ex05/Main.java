package ch14.ex05;

public class Main extends Thread{

	public static void main(String[] args) {

		for(int i=0;i<100;i++) {
			new Main().start();
		}

		new Counter().sub(10);
	}

	public void run() {
		Counter.count();
	}
}
