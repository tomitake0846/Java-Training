package ch03.ex23;

import java.util.function.Function;

public class PairUtils {
	public static <T,U> Pair<U> map(Pair<T> pair,Function<T,U> func) {
		return new Pair<U>(func.apply(pair.getOrigin()));
	}
}
