package ch22.ex05;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		//ダイスの数
		int NOfDice = 3;

		//シミュレート回数
		int N=10000;

		Simulator s = new Simulator(NOfDice,N,() -> {return (int) (( Math.random() * 6) + 1);});

		s.compare(10);

		s = new Simulator(NOfDice,N,() -> {	return new Random().nextInt(6) + 1;});

		s.compare(10);
	}

}
