package ch06.ex07;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

import ch06.ex07.MapAnalyser;

class MapAnalyserTest {

	@Test
	void maxTest1() {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String,Long>();
		map.put("1", 1L);
		map.put("2", 22L);
		map.put("3", 333L);
		assertEquals("3" , MapAnalyser.max(map));
	}

	@Test
	void maxTest2() {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String,Long>();
		map.put("1", 1L);
		map.put("2", 22L);
		map.put("2", 22L);
		map.put("3", 333L);
		assertEquals("3" , MapAnalyser.max(map));
	}

	@Test
	void maxTest3() {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String,Long>();
		map.put("1", 1L);
		map.put("2", 22L);
		map.put("3", 333L);
		map.put("4", 333L);
		assertEquals("4" , MapAnalyser.max(map));

	}

	@Test
	void emptyMapTest() {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String,Long>();
		assertThrows(IllegalStateException.class , () -> MapAnalyser.max(map));
	}

	@Test
	void nullTest() {
		assertThrows(NullPointerException.class , () -> MapAnalyser.max(null));
	}

}
