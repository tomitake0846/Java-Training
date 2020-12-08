package ch06.ex03;

public class Main {

	public static void main(String[] args) {
		BenchMark mark = new BenchMark(new AtomicLongBench());

		System.out.println("AtomicLong :"+mark.start());

		mark = new BenchMark(new LongAdderBench());

		System.out.println("longAdder :"+mark.start());

	}

}
