package ch09.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InputStreamFilter {
	public static List<String> read(InputStream is, Predicate<String> filter) throws IOException{
		try(InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr)){
			String line;
			List<String> result = new ArrayList<>();
			while((line = br.readLine()) != null) {
				if(filter.test(line)) {
					result.add(line);
				}
			}
			return result;
		}
	}
}
