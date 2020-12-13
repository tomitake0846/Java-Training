package ch06.ex06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordParser {
	private final String WORD_DELIMITER = " ";

	public List<String> parseToWordList(File file) throws IOException{
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)){
			String line;
			List<String> list = new ArrayList<>();
			while((line = br.readLine()) != null) {

				String[] words = line.split(WORD_DELIMITER);

				for(String word : words) {
					list.add(word);
				}
			}
			return list;
		} catch (IOException e) {
			throw e;
		}
	}
}