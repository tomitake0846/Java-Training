package ch05.ex05;

public class Main {

	public static void main(String[] args) {
		long days = Durations.numberOfMyLivingPeriod(Durations::daysDuration);
		System.out.println(days);

	}

}
