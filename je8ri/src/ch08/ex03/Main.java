package ch08.ex03;

public class Main {

	public static void main(String[] args) {
		System.out.println(Euclidean.run(1071, 1029, (a,b) -> a%b ));
		System.out.println(Euclidean.run(1071, 1029, (a,b) -> Math.floorMod(a, b) ));
		System.out.println(Euclidean.run(1071, 1029, Euclidean::rem ));

		System.out.println(Euclidean.run(1071, -1029, (a,b) -> a%b ));
		System.out.println(Euclidean.run(1071, -1029, (a,b) -> Math.floorMod(a, b) ));
		System.out.println(Euclidean.run(1071, -1029, Euclidean::rem ));
	}

}
