package ch09.ex02;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Throwable{
		/* try catch*/
		Scanner in = null;
		PrintWriter out = null;
		Throwable ExceptionInTry = null;

		try {
			in = new Scanner(Paths.get("/usr/share/dict/words"));
			out = new PrintWriter("/tmp/out,txt");

			while(in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionInTry = e;
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

				if(ExceptionInTry != null) {
					ExceptionInTry.addSuppressed(e);
				}
			}

			try {
				if(out != null) {
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

				if(ExceptionInTry != null) {
					ExceptionInTry.addSuppressed(e);
				}
			}

			if(ExceptionInTry != null) {
				throw ExceptionInTry;
			}
		}
	}
}
