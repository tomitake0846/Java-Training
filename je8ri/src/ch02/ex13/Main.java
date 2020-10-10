package ch02.ex13;

import java.util.Map;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		ShortWordCounter swc = new ShortWordCounter();
		Stream<String> s = Stream.of("1","22","333","4444","55555","55555","11111111111","not count string:::::");
		Map<Integer,Long> map = swc.count(s);

		for(Integer key : map.keySet()) {
			System.out.println("length :" + key + "-> count :" + map.get(key));
		}

	}

}
