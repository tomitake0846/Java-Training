package ch23.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime r = Runtime.getRuntime();
		Process process = r.exec(args);
		System.out.println("*** InputStream ***");
		printSO(process.getInputStream());

		System.out.println("\n*** ErrorStream ***");
		printSO(process.getErrorStream());
	}

	private static void printSO(InputStream is) throws IOException {
		int lineCount = 0;
		try(InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr)) {
			String line;
			while( (line = br.readLine()) != null ) {
				System.out.println(lineCount + ":" + line);
				lineCount++;
			}
		}
	}

}
