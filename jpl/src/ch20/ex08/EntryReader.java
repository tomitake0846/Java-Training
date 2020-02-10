package ch20.ex08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntryReader {

	private static Map<Integer,String> map = new HashMap<Integer,String>();

	public static void main(String[] args) {
		read();
		print();
	}
	private static void read() {
		File file = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch20\\ex08\\test.txt");
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)) {
			int count = 1;
			int startIndex = 1;
			String line;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				//when read separater '%%'
				if(line.equals("%%")) {
					map.put(startIndex,sb.toString());
					sb = new StringBuilder();
					startIndex = count+1;
				} else {
					sb.append(line);
					sb.append('\n');
				}
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void print() {
		int N = 10;
		List<Integer> list = new ArrayList<Integer>(map.keySet());

		for(int i=0;i<N;i++) {
			int index = (int)(Math.random() * list.size());
			int lineNum = list.get(index);
			String entry = map.get(lineNum);
			System.out.println(lineNum + ":" + entry);
		}
	}

}
