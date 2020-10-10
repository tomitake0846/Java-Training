package ch02.ex11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class MergeStream<T> {

	// 前提
	// list.size() == streamの要素数
	public ArrayList<T> merge(ArrayList<T> list, Stream<T> stream) {
		ArrayList<T> result = new ArrayList<T>(list.size() * 2);
		result.addAll(list);
		result.addAll(list);

		BiFunction<AtomicInteger,T,AtomicInteger> bif = (a,v) -> {
			result.set(a.getAndIncrement(),v);
			return a;
		};
		BinaryOperator<AtomicInteger> bio = (l,r) -> {
			return l;
		};

		stream.reduce(new AtomicInteger(list.size()),
				bif,
				bio);

		return result;
	}
}
