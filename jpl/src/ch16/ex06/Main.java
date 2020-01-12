package ch16.ex06;

public class Main {

	public static void main(String[] args) {
		Interpret i = new Interpret("ch16.ex06.test");
		i.setField("test", 100);
		i.setField("st", "fugafuga");
		i.setField("t", new test());
		System.out.println(i.getFieldValue("test"));
		System.out.println(i.getFieldValue("st"));
		System.out.println(i.getFieldValue("t"));
	}

}
class test {
	public int test;
	public String st;
	public test t;
}