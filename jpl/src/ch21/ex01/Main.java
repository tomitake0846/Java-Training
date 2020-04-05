package ch21.ex01;

public class Main {
	public static void main(String[] args) {
		TextToList list = new TextToList();
		for(String str : list.getList("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch21\\ex01\\test.txt")) {
			System.out.println(str);
		}
	}
}
