package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.regex.PatternSyntaxException;

public class Grep {
	public static void grep(String regexStr,String path) throws IOException {
		Grep.grep(regexStr, path,System.out::println);
	}

	public static void grep(String regexStr,String path,Consumer<String> process) throws IOException {
		if(!Regex.valid(regexStr)) {
			throw new PatternSyntaxException("In Grep class, Invalid variable regexStr :"+regexStr,regexStr,-1);
		}

		if(path == null) {
			throw new InvalidPathException("null", "input path is null");
		}

		Path rootPath = Paths.get(path);
		if(!Files.exists(rootPath)) {
			throw new InvalidPathException(path, "Invalid input path :"+path);
		}

		Files.walk(rootPath,Integer.MAX_VALUE)
		.filter(Files::isRegularFile)
		.forEach(p -> FileProcessor.run(regexStr, p, process));
	}
}
