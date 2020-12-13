package ch09.ex03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

public class Main {

	/*Ans ... throwする例外が複数ある場合は、横並べで書く*/
	public static void main(String[] args) throws FileNotFoundException , UnknownHostException {
		try {
			System.out.println("test");
			PrintWriter out = new PrintWriter("");
			throw new UnknownHostException();
		} catch (FileNotFoundException | UnknownHostException ex) {
			throw ex;
		}
	}

}
