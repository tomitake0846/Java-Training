package ch21.ex01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextToList {
	public List<String> getList(String fileName) {
		List<String> list = new ArrayList<String>();

		try(FileReader fr = new FileReader(new File(fileName));
			BufferedReader br = new BufferedReader(fr);) {
			String line;
			while((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Collections.sort(list);
		return list;
	}
}
