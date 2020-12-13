package ch06.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebUtils {

	public static URL toURL(String url) throws IOException{
		try {
			return new URL(url);
		} catch (IOException e) {
			throw e;
		}
	}

	public static List<String> readPage(URL url){
		List<String> list = new ArrayList<>();
		HttpURLConnection c = null;
		try {
			c = (HttpURLConnection)url.openConnection();

			try (InputStreamReader isr = new InputStreamReader(c.getInputStream());
					BufferedReader br = new BufferedReader(isr)){

				String line;
				while((line = br.readLine()) != null) {
					list.add(line);
				}
			} catch (IOException e) {
				throw e;
			}

		} catch (IOException e){}
		finally {
			if(c != null) {
				c.disconnect();
			}
		}
		return list;
	}

	public static List<URL> getLinks(List<String> htmlCode){
		List<URL> urlList = new ArrayList<>();

		for(String code : htmlCode) {

			/* example
			 * code : <a href='http://test.evil.com'> http://test.com </a>;
			 * WebUtils.parseHTTP(code) : ["http://test.evil.com" , "http://test.com"]
			 * */
			for(String link :WebUtils.parseHTTP(code)) {
				try {
					urlList.add(WebUtils.toURL(link));
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return urlList;
	}


	private static final String HTTP_PATTERN = "(http|https)://([a-zA-Z\\-_]+\\.)+[a-zA-Z]+";
	private static final String HTTP_REGEX = "^(?=.*" + HTTP_PATTERN + ").*$";

	public static boolean isHTTP(String target) {
		return target.matches(HTTP_REGEX);
	}

	public static String[] parseHTTP(String target) {
		Pattern p = Pattern.compile(HTTP_PATTERN);
		Matcher m = p.matcher(target);
		List<String> list = new ArrayList<>();
		while(m.find()) {
			list.add(m.group());
		}

		return list.toArray(new String[list.size()]);

	}
}
