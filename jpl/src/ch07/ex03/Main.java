package ch07.ex03;

public class Main {
	public static void main(String[] args) {
		TriangleOfPascal t = new TriangleOfPascal(12);
		t.paint();

		t = new TriangleOfPascal(8);
		t.paint();

		t = new TriangleOfPascal(16);
		t.paint();
	}
}
