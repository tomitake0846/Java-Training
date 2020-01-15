package ch14.ex06;

public class Main {

	public static void main(String[] args) {

		PrintRunningTime prt = new PrintRunningTime(new SayHello(),new SayGoodBye());
		prt.run();

	}

}
