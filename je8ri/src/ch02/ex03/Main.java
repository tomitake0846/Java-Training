package ch02.ex03;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		measurment(( st ->  st.filter(e -> e.length() > 3)),getWords(10000000));
		measurment(( st ->  st.filter(e -> e.length() > 3)),getWords(10000000).parallel());
	}
	public static Stream<String> getWords(int size) {
		return Stream.iterate(0 , i -> i + 1).
			limit(size).
			map(e -> ""+e);

	}
	public static void measurment(Consumer<Stream<String>> target,Stream<String> stream) {
		long start = System.nanoTime();
		target.accept(stream);
		long end = System.nanoTime();
		System.out.println("time :" + (end - start));
	}
}
