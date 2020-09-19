package ch01.ex02;

import java.io.File;
import java.util.Arrays;

public class ListDirectory {

	public static void main(String[] args) {
		ListDirectory ld = new ListDirectory();

		String filePath = "C://Users//test//src//Java-Training//je8ri//src//ch01//ex02/";
		Arrays.stream(ld.ListSubdirectory(filePath+"test1/")).forEach(System.out::println);
		System.out.println();
		Arrays.stream(ld.ListSubdirectory(filePath+"test2/")).forEach(System.out::println);
		System.out.println();
		Arrays.stream(ld.ListSubdirectory(filePath+"test3/")).forEach(System.out::println);

		Arrays.stream(ld.ListSubdirectoryMethodReference(filePath+"test1/")).forEach(System.out::println);
		System.out.println();
		Arrays.stream(ld.ListSubdirectoryMethodReference(filePath+"test2/")).forEach(System.out::println);
		System.out.println();
		Arrays.stream(ld.ListSubdirectoryMethodReference(filePath+"test3/")).forEach(System.out::println);
	}


	public File[] ListSubdirectory(String filePath) {
		return new File(filePath).listFiles(x -> x.isDirectory());
	}

	public File[] ListSubdirectoryMethodReference(String filePath) {
		return new File(filePath).listFiles(File::isDirectory);
	}
}
