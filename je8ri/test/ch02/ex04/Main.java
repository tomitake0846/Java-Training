package ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		int[] values = {1,4,9,16};
		//print memory address of "values".
		Stream.of(values).forEach(System.out::println);

		//print element of "values".
		IntStream.of(values).forEach(System.out::println);

	}

}
