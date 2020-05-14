package ch23.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime r = Runtime.getRuntime();
		Process process = r.exec(args);

		String terminationStr = "c";

		System.out.println("*** InputStream ***");
		printSO(process,process.getInputStream(),terminationStr);

		System.out.println("\n*** ErrorStream ***");
		printSO(process,process.getErrorStream(),terminationStr);
	}

	private static void printSO(Process p,InputStream is,String terminationStr) throws IOException {
		int lineCount = 0;
		try(InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr)) {
			String line;
			while( (line = br.readLine()) != null ) {
				if(line.contains(terminationStr)) {
					System.out.println("terminated.");
					System.out.println("terminationStr :" + terminationStr);
					System.out.println("line :" + line);
					break;
				}
				System.out.println(lineCount + ":" + line);
				lineCount++;
			}
			p.destroy();
		}
	}

}
