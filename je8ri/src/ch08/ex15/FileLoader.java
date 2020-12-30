package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

class FileLoader {
	public static Stream<String> read(Path path) throws IOException {
		return Files.lines(path);
	}
}
