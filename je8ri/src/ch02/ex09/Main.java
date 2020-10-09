package ch02.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		FlatList<String> fl = new FlatList<>();

		//good
		System.out.println(fl.flatList1(test()).toString());

		//good
		System.out.println(fl.flatList2(test()).toString());

		//good
		System.out.println(fl.flatList3(test()).toString());

		//bad
		System.out.println(fl.flatList3(test().parallel()).toString());
	}

	public static Stream<ArrayList<String>> test() {
		return Stream.of(new ArrayList<String>(Arrays.asList("a","b","c")),
				new ArrayList<String> (Arrays.asList("d","e","f")),
				new ArrayList<String> (Arrays.asList("g","h","i")));
	}

}
