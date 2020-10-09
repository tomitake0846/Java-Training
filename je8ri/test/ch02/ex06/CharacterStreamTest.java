package ch02.ex06;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class CharacterStreamTest {

	@Test
	void test() {
		List<Character> list = CharacterStream.characterStream("test").collect(Collectors.toList());
		String result = "";
		for(char c : list) {
			result += c;
		}
		assertEquals("test",result);

	}

}
