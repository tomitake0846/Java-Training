package ch14.ex01;

public class Main extends Thread{

	public Main(String string) {
		super(string);
	}

	public static void main(String[] args) {
		Thread thread = new Main("Main Thread");
		thread.run();
	}

	public void run() {
		System.out.println(this.getName());
	}
}