package ch02.ex09;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatList<T> {
	public ArrayList<T> flatList1(Stream<ArrayList<T>> stream) {
		return stream.reduce((a,v) -> Stream.concat(a.stream(),v.stream())
				.collect(Collectors.toCollection(ArrayList::new))).orElse(new ArrayList<T>());
	}

	public ArrayList<T> flatList2(Stream<ArrayList<T>> stream) {
		BinaryOperator<ArrayList<T>> op = (a,v) -> {
			a.addAll(v);
			return a;
		};

		return stream.reduce(new ArrayList<T>(),op);
	}

	public ArrayList<T> flatList3(Stream<ArrayList<T>> stream) {
		BiFunction<ArrayList<T>,ArrayList<T>,ArrayList<T>> bif = (a,v) -> {
			a.addAll(v);
			return a;
		};
		BinaryOperator<ArrayList<T>> bio = (a,v) -> {
			return v;
		};
		return stream.reduce(new ArrayList<T>(),bif,bio);
	}
}
