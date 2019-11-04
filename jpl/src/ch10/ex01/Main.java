package ch10.ex01;

public class Main {

	public static void main(String[] args) {

		test("Hello\nWorld!");
		test("<Sctipt>alert('XSS')</script>");
		test("\012");
	}
	public static void test(String test) {
		Escape e = new Escape();
		System.out.println("before : " + test);
		System.out.println("after  : " + e.escape(test));
	}
}
