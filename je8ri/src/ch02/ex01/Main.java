package ch02.ex01;

public class Main {
	public static void main(String[] args) {
		WordCounter wc = new WordCounter();
		String[] ary = {
				"development",
				"administration",
				"operation",
				"cloudEngineer"
		};
		System.out.println(wc.count(ary));
	}
}
