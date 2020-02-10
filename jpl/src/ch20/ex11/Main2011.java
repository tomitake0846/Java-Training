package ch20.ex11;

import java.io.File;

public class Main2011 {

	public static void main(String[] args) {
		File dir = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch20\\ex11\\testfiles");
		String[] files = dir.list(new SuffixFilter("error.log"));
		for(String file : files) {
			System.out.println(file);
		}

	}

}
