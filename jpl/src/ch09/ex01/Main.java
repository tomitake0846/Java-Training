package ch09.ex01;

public class Main {

	private static double posiInf = Double.POSITIVE_INFINITY;
	private static double negaInf = Double.NEGATIVE_INFINITY;

	public static void main(String[] args) {
		addition();
		subtraction();
		multiplication();
		division();
	}
	private static void addition() {
		System.out.println("infinit addition");
		System.out.println("posiInf + posiInf = "+(posiInf + posiInf));
		System.out.println("posiInf + negaInf = "+(posiInf + negaInf));
		System.out.println("negaInf + negaInf = "+(negaInf + negaInf));
	}
	private static void subtraction() {
		System.out.println("\ninfinit subtraction");
		System.out.println("posiInf - posiInf = "+(posiInf - posiInf));
		System.out.println("posiInf - negaInf = "+(posiInf - negaInf));
		System.out.println("negaInf - negaInf = "+(negaInf - negaInf));
	}
	private static void multiplication() {
		System.out.println("\ninfinit multoplcation");
		System.out.println("posiInf * posiInf = "+(posiInf * posiInf));
		System.out.println("posiInf * negaInf = "+(posiInf * negaInf));
		System.out.println("negaInf * negaInf = "+(negaInf * negaInf));
	}
	private static void division() {
		System.out.println("\ninfinit division");
		System.out.println("posiInf / posiInf = "+(posiInf / posiInf));
		System.out.println("posiInf / negaInf = "+(posiInf / negaInf));
		System.out.println("negaInf / negaInf = "+(negaInf / negaInf));
	}
}
