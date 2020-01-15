package ch14.ex04;

public class Main extends Thread{

	public static void main(String[] args) {

		for(int i=0;i<100;i++) {
			new Main().start();
		}

	}

	public void run() {
		Counter.count();
	}
}
