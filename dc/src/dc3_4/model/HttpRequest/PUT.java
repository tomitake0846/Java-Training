package dc3_4.model.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import dc3_4.model.utils.JsonProcessor;

class PUT implements HTTPMethod{
	public String exec(String uri,Map<String,String> params) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(uri).openConnection();

        put(conn,params);
        return getResponse(conn);
	}
	private void put(HttpURLConnection conn,Map<String,String> params) throws IOException {
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json;");

		String payload="";
		if(params != null) {
			payload = JsonProcessor.toJsonFormat(params);
		}
		try(OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream())){
			out.write(payload);
			out.close();
		} catch (IOException e) {
			throw e;
		}
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
