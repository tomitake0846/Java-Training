package ch03.ex20;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilsTest {

	@Test
	void test() {
		List<String> strs = Arrays.asList("1","2");
		List<Integer> ints = ListUtils.map(strs, (s) -> Integer.parseInt(s));
		assertEquals(strs.size(),ints.size());
		assertEquals(1,ints.get(0));
		assertEquals(2,ints.get(1));
	}

	@Test
	void NullpoTest() {
		assertThrows(NullPointerException.class , () -> ListUtils.map(null,(s) -> s));
	}

}
