package ch02.ex11;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		MergeStream<String> m = new MergeStream<String>();

		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		Stream<String> stream = Stream.of("d","e","f");

		//順番変わる
		m.merge(list, stream.parallel()).stream().forEach(System.out::println);

	}

}
