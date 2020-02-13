package ch20.ex10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
	private Map<String,Integer> map;
	public WordCount(String path) throws IOException{
		this.map = new HashMap<String,Integer>();
		count(new File(path));
	}
	private void count(File file) throws IOException{
		FileReader fr = new FileReader(file);
		StreamTokenizer sr = new StreamTokenizer(fr);
		while(sr.nextToken() != StreamTokenizer.TT_EOF) {
			String word = sr.sval;
			if(word == null) continue;
			if(map.containsKey(word)) {
				int currentCount = map.get(word);
				map.put(word, currentCount+1);
			} else {
				map.put(word, 1);
			}
		}
	}
	public void print() {
		for(String key : map.keySet()) {
			System.out.println(key + ":"+ map.get(key));
		}
	}
}
