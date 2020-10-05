package ch02.ex05;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		getRandomStream(25214903917L,11,(long)Math.pow(2, 48),10).
			limit(10).
			forEach(System.out::println);
	}
	public static Stream<Long> getRandomStream(long a,int c, long m,int seed){
		return LongStream.iterate(seed, s -> (a * s + c) % m ).boxed();
	}
}
