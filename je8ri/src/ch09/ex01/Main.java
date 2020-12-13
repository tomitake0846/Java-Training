package ch09.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		/*try with resource*/
		try(Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
				PrintWriter out = new PrintWriter("/tmp/out.txt")) {
			while(in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		/* try catch*/
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get("/usr/share/dict/words"));
			out = new PrintWriter("/tmp/out,txt");

			while(in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if(out != null) {
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
