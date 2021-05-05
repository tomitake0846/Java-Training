package dc3_4.model.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

class GET implements HTTPMethod{
	public String exec(String uri,Map<String,String> params) throws IOException {
		String payload = buildPayload(params);
		if(!payload.isEmpty()) {
			uri += "?" + payload;
		}
		HttpURLConnection conn = (HttpURLConnection) new URL(uri).openConnection();

        get(conn);
        return getResponse(conn);
	}
	private String buildPayload(Map<String,String> params) {
		String payload="";
		if(params != null) {
			for(String key : params.keySet()) {
				payload = key+"="+params.get(key);
			}
		}
		return payload;
	}
	private void get(HttpURLConnection conn) throws IOException {
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.connect();
	}

	private String getResponse(HttpURLConnection conn) throws IOException {
		StringBuilder sb = new StringBuilder();
		try(InputStream in = conn.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
				String line;
				while((line = reader.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException e) {
				throw e;
			}
		return sb.toString();
	}
}
