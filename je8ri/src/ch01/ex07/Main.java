package ch01.ex07;

public class Main {
	public static void main(String[] args) {
		Runner.andThen(() -> {
			System.out.println("1");
		}
		, () -> {
			System.out.println("2");
		}).run();
	}
}
