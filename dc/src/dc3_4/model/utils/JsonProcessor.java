package dc3_4.model.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessor {
	public static Map<String,String> jsonToMap(String json) throws JsonMappingException, JsonProcessingException {
		Map<String,String> map = new HashMap<String,String>();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);

		@SuppressWarnings("rawtypes")
		Map root = mapper.readValue(json,new TypeReference<HashMap<String,String>>(){});

		for(Object str : root.keySet()) {
			String key = str.toString();
			String val = root.get(key).toString();
			map.put(key, val);
		}

		return map;
	}

	public static String toJsonFormat(Map<String,String> map) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
}
