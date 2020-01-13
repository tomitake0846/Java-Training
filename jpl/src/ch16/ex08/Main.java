package ch16.ex08;

public class Main {

	public static void main(String[] args) {
		Interpret i = new Interpret("ch16.ex08.test");
		i = new Interpret("ch16.ex08.test",1);
		i = new Interpret("ch16.ex08.test","test");
	}

}
class test {
	public test() {
		System.out.println("no args");
	}
	//runtime error
//	public test(int i) {
	public test(Integer i) {
		System.out.println("a args :"+i);
	}
	public test(String s) {
		System.out.println("a args :"+s);
	}
}