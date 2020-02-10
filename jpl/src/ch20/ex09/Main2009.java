package ch20.ex09;

import java.io.File;

public class Main2009 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch20\\ex08\\test.txt");
		FileProperty fp = new FileProperty();
		fp.print(file.getAbsolutePath());
	}

}
