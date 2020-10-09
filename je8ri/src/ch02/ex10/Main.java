package ch02.ex10;

import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Stream<Double> stream = Stream.of(1.0,2.0,3.0);
		Average a = new Average();
		System.out.println(a.getAverage(stream));

		Double x = new Double(1.0);
		System.out.println(x.equals(1.0));
	}
}
