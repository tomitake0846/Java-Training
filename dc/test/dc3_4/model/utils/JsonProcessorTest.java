package dc3_4.model.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

class JsonProcessorTest {

	@Test
	void parseSuccess() throws JsonMappingException, JsonProcessingException {
		String response = "{\"user\": {\"name\": \"Pompom Pudding\",\"score\": {\"kokugo\": \"good\",\"sansuu\": 100},\"favorites\": [\"soccer\", \"puzzle\"]}}";
		Map<String,String> map = JsonProcessor.jsonToMap(response);
		for(String key :map.keySet()) {
			assertEquals("{\"name\":\"Pompom Pudding\",\"score\":{\"kokugo\":\"good\",\"sansuu\":100},\"favorites\":[\"soccer\",\"puzzle\"]}", map.get(key));
			return;
		}
		fail("not exist expected key in map.");

	}

	@Test
	void childParseSuccess() throws JsonMappingException, JsonProcessingException {
		String response = "{\"user\": {\"name\": \"Pompom Pudding\",\"score\": {\"kokugo\": \"good\",\"sansuu\": 100},\"favorites\": [\"soccer\", \"puzzle\"]}}";
		Map<String,String> map = JsonProcessor.jsonToMap(response);
		Map<String,String> user = JsonProcessor.jsonToMap(map.get("user"));

		assertEquals("{favorites=[\"soccer\",\"puzzle\"], score={\"kokugo\":\"good\",\"sansuu\":100}, name=Pompom Pudding}",user.toString());
		for(String key :user.keySet()) {
//			System.out.println(key + ":"+user.get(key));

			switch(key) {
			case "favorites": assertEquals("[\"soccer\",\"puzzle\"]",user.get(key));break;
			case "score": assertEquals("{\"kokugo\":\"good\",\"sansuu\":100}",user.get(key));break;
			case "name": assertEquals("Pompom Pudding",user.get(key));break;
			default : fail("undefined key");
			}
		}
	}

	@Test
	void toJsonFormatSuccess() throws JsonProcessingException {
		Map<String,String> body = new HashMap<>();
		body.put("user-id", "admin");
		body.put("password", "admin");
		assertEquals("{\"password\":\"admin\",\"user-id\":\"admin\"}",JsonProcessor.toJsonFormat(body));
	}

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
