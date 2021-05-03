package dc3_4.model.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

class JsonProcessorTest {

	@Test
	void jsonToMapSuccess() throws JsonProcessingException {
		String json = "{\"Font Family\":\"Serif\",\"Font Size\":\"40.0\",\"X coordinate\":\"200.0\",\"BackGround Color\":\"black\",\"Character Color\":\"white\",\"Y coordinate\":\"200.0\",\"Font Name\":\"ITALIC\"}";
		Map<String,String> map = JsonProcessor.jsonToMap(json);
		assertEquals("ITALIC",map.get("Font Name"));
		assertEquals("Serif",map.get("Font Family"));
		assertEquals("40.0",map.get("Font Size"));
		assertEquals("200.0",map.get("X coordinate"));
		assertEquals("white",map.get("Character Color"));
		assertEquals("black",map.get("BackGround Color"));
		assertEquals("200.0",map.get("Y coordinate"));
	}

}
