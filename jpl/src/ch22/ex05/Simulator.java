package ch22.ex05;

public class Simulator {
	private int NOfDice;
	private int N;
	private RandomNumberGenerator generator;
	private int[] theoreticalValueArray;
	private final int MIN;
	private final double MAX;
	public Simulator(int NOfDice,int N,RandomNumberGenerator generator) {
		this.NOfDice = NOfDice;
		this.N = N;
		this.generator = generator;
		this.MIN = 1 * NOfDice;
		this.MAX = Math.pow(6,NOfDice);
		this.theoreticalValueArray = getTheoreticalValueArray(NOfDice);
	}

	//TheoreticalValue
	public double getTheoreticalValue(int sum) {
		if(!validSum(sum)) {
			throw new IllegalArgumentException();
		}
		return theoreticalValueArray[sum - this.MIN] / this.MAX;
	}

	public double getActualValue(int sum) {
		if(!validSum(sum)) {
			throw new IllegalArgumentException();
		}
		int count=0;
		for(int i=0;i<N;i++) {
			int x = 0;
			for(int j=0;j<NOfDice;j++) {
				x += this.generator.getRandom();
			}
			if(sum == x) {
				count ++;
			}
		}
		return count / (double)N;
	}

	public void compare(int sum) {
		double theorem = getTheoreticalValue(sum);
		double actual = getActualValue(sum);

		System.out.println("理論値 :"+theorem);
		System.out.println("観測値 :"+actual);
	}

	private boolean validSum(int sum) {
		return (this.MIN <= sum) && (sum <= this.MAX);
	}

	private int[] getTheoreticalValueArray(int NOfDice) {
		int[] ary = {1,1,1,1,1,1};

		SumOfDiceValue s = new SumOfDiceValue();
		for(int i=1;i<NOfDice;i++) {
			ary = s.getCountArray(ary);
		}

		return ary;
	}
}
