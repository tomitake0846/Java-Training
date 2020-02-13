package ch20.ex07;

import java.io.File;
import java.io.IOException;

public class Main2007 {

	public static void main(String[] args) throws IOException {
		Attr attr = new Attr("foo","bar");
		File file = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch20\\ex07\\test.txt");
		attr.writeAttr(file.getAbsolutePath());

		attr = new Attr(file);

		System.out.println(attr.getName());
		System.out.println(attr.getValue());

	}

}
