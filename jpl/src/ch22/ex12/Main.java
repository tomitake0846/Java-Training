package ch22.ex12;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch22\\ex12\\test.properties");

		try(FileReader fr = new FileReader(f)) {
			Attributed a = AttributeReader.readAttrs(fr);
			Iterator<Attr> i = a.attrs();
			while(i.hasNext()) {
				Attr attr = i.next();
				System.out.println(attr.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
