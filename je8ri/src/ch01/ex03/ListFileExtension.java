package ch01.ex03;

import java.io.File;
import java.util.Arrays;

public class ListFileExtension {

	public static void main(String[] args) {
		ListFileExtension lfe = new ListFileExtension();

		String filePath = "C://Users//test//src//Java-Training//je8ri//src//ch01//ex02/";
		Arrays.stream(lfe.listFileExtension(filePath+"test1/","txt")).forEach(System.out::println);
		System.out.println();
		Arrays.stream(lfe.listFileExtension(filePath+"test2/","txt")).forEach(System.out::println);
		System.out.println();
		Arrays.stream(lfe.listFileExtension(filePath+"test3/","txt")).forEach(System.out::println);

	}

	public File[] listFileExtension(String filePath,String extension) {
		File[] files = new File(filePath).listFiles(File::isFile);
		String regex = ".+"+extension+"$";

		return Arrays.stream(files)
			.filter(f -> f.getName().matches(regex))
			.toArray(File[]::new);
	}
}
