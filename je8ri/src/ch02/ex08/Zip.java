package ch02.ex08;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zip {
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		//リストに変換した時点で負けた気がする...
		List<T> firstList = first.collect(Collectors.toList());
		List<T> secondList = second.collect(Collectors.toList());

		long min = firstList.size();
		long secondCount = secondList.size();
		if(min > secondCount) {
			min = secondCount;
		}

		Stream<node<T>> firstNode = firstList.stream().limit(min).map(e -> new evenNode<T>(e));
		Stream<node<T>> secondNode = secondList.stream().limit(min).map(e -> new oddNode<T>(e));

		return Stream.of(firstNode,secondNode)
				.flatMap(e -> e)
				.sorted(Comparator.comparing(node::getIndex))
				.map(e -> e.item);
	}

	private static class node<T>{
		int index;
		T item;
		int getIndex() {
			return index;
		}
	}

	private static class evenNode<T> extends node<T>{
		static int evenCount = 0;
		private evenNode(T item) {
			this.item = item;
			this.index = evenCount+=2;
		}
	}

	private static class oddNode<T> extends node<T>{
		static int oddCount = 1;
		private oddNode(T item) {
			this.item = item;
			this.index = oddCount+=2;
		}
	}
}

