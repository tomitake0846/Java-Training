package ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SortFiles {
	public File[] sortFiles(File[] files) {
		return Arrays.asList(fileFilter(files,File::isFile),fileFilter(files,File::isDirectory))
			.stream()
			.flatMap(s -> s.sorted())
			.toArray(File[]::new);

	}

	private Stream<File> fileFilter(File[] files,Predicate<File> p) {
		return Arrays.stream(files).filter(p);
	}

}
