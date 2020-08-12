package ch22.ex07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		File f = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch22\\ex07\\test.csv");
		try(FileReader br = new FileReader(f);) {
			List<String[]> list = CSVTable.readCSVTable(br,4);

			for(String[] ary : list) {
				System.out.println(Arrays.toString(ary));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
