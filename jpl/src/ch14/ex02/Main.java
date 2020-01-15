package ch14.ex02;

public class Main {

	public static void main(String[] args) {
		PrintServer thread = new PrintServer();
		badCall(thread);
		badCall(thread);
		badCall(thread);
	}
	public static void badCall(PrintServer thread) {
		try {
			thread.run();
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}
}