package ch22.ex11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVTable {

	public static List<String[]> readCSVTable(File source) throws IOException{

		List<String[]> list = new ArrayList<String[]>();

		try (FileReader fr = new FileReader(source);
			BufferedReader br = new BufferedReader(fr)) {
			String line;

			while((line = br.readLine()) != null) {
				list.add(parse(line));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	private static String[] parse(String line) {
		StringTokenizer st = new StringTokenizer(line,",");
		List<String> list = new ArrayList<String>();

		while(st.hasMoreElements()) {
			list.add(st.nextToken());
		}

		return list.toArray(new String[list.size()]);
	}
}
