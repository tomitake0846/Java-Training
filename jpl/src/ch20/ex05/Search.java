package ch20.ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Search {

	private File file;
	private Map<Integer,String> map;
	public Search(String filePath) {
		this.file = new File(filePath);
		this.map = new TreeMap<Integer,String>();
		init();
	}
	public void search(String keyword) {
		for(Integer key : map.keySet()) {
			String line = map.get(key);
			if(line.contains(keyword)) {
				System.out.println(key + ":" + line);
			}
		}
	}

	private void init() {
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);) {
			String line;
			int count = 1;
			while( (line = br.readLine()) != null) {
				this.map.put(count,line);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
