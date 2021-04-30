package dc3_4.model.HttpRequest;

import java.io.IOException;
import java.util.Map;

public interface HTTPMethod {
	String exec(String uri,Map<String,String> params) throws IOException;
}
