package ch22.ex09;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		start("^(.*),(.*),(.*),(.*)");
		start("(.*),(.*),(.*),(.*)$");
		start("^(.*),(.*),(.*),(.*)$");
		start("^([^,]*),([^,]*),([^,]*),([^,]*)");
		start("([^,]*),([^,]*),([^,]*),([^,]*)$");
		start("^(.*?),(.*?),(.*?),(.*?)");
		start("(.*?),(.*?),(.*?),(.*?)$");
	}

	public static void start(String exp) {
		File f1 = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch22\\ex09\\test1.csv");
		File f2 = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch22\\ex09\\test2.csv");
		long timeF1 = benchmark(exp,f1);
		long timeF2 = benchmark(exp,f2);
		System.out.println("regex :"+exp);
		System.out.println("f1 :"+timeF1);
		System.out.println("f2 :"+timeF2);
		System.out.println("**********************");
	}

	public static long benchmark(String exp,File f) {
		long start = System.currentTimeMillis();

		try(FileReader br = new FileReader(f);) {
			List<String[]> list = CSVTable.readCSVTable(br,exp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		return end - start;
	}

}
