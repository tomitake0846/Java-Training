package ch08.ex15;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

public class FileProcessor {
	public static void run(String regexStr,Path path,Consumer<String> process){
		try {
			FileLoader.read(path)
			.filter(s -> Regex.matches(s,regexStr))
			.forEach(process);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
