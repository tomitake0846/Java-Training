package ch08.ex03;

import java.util.function.BiFunction;

public class Euclidean {
	public static int run(int a, int b, BiFunction<Integer,Integer,Integer> mod) {
		if(b != 0) {
			return run(b, mod.apply(a, b) ,mod);
		} else {
			return a;
		}
	}

	public static int rem(int a, int b) {
		return Math.abs(a%b);
	}
}
