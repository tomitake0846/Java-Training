package ch22.ex11;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch22\\ex11\\test.csv");
		List<String[]> list = CSVTable.readCSVTable(f);

		for(String[] ary : list) {
			System.out.println(Arrays.toString(ary));
		}

	}

}
