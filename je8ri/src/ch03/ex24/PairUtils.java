package ch03.ex24;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class PairUtils {
	public static <T,U> Pair<U> map(Pair<T> pair,Function<T,U> func) {
		return new Pair<U>(func.apply(pair.getOrigin()));
	}

	public static <T,U,R> Stream<Object> flatMap(Pair<T> pair) {
		return Stream.of(pair.getOrigin(),pair.getPair());
	}

	public static <T,U,R> R flatMap(Pair<T> pair, BiFunction<T,U,R> func) {
		return func.apply(pair.getOrigin(), (U) pair.getPair());
	}
}
