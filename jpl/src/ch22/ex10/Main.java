package ch22.ex10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch22\\ex10\\test.sh");
		try(FileReader br = new FileReader(f);) {
			List<String> list = CommentIgnore.readWithoutComment(br);

			for(String line : list) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
