package ch22.ex02;

public class Main {
	public static void main(String[] args) {
		WhichChars wc = new WhichChars("Testing 1 2 3");
		wc = new WhichChars("禿動圀");
		System.out.println(wc.toString());
	}
}
