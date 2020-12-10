package ch06.ex07;

import java.util.concurrent.ConcurrentHashMap;

public class MapAnalyser {
	public static String max (ConcurrentHashMap<String, Long> map) {
		if (map.size() == 0) throw new IllegalStateException("map is empty.");
		return map.reduceEntries(5, (e1,e2) -> e1.getValue() > e2.getValue() ? e1 : e2).getKey();
	}
}
