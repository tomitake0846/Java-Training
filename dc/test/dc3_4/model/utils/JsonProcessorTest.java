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

		assertEquals("{favorites=[\"soccer\",\"puzzle\"], score={\"kokugo\":\"good\",\"sansuu\":100}, name=\"Pompom Pudding\"}",user.toString());
		for(String key :user.keySet()) {
//			System.out.println(key + ":"+user.get(key));

			switch(key) {
			case "favorites": assertEquals("[\"soccer\",\"puzzle\"]",user.get(key));break;
			case "score": assertEquals("{\"kokugo\":\"good\",\"sansuu\":100}",user.get(key));break;
			case "name": assertEquals("\"Pompom Pudding\"",user.get(key));break;
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

}
