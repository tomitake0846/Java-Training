package ch06.ex03;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderBench implements BenchMarkTarget{

	private LongAdder la;

	public LongAdderBench() {
		la = new LongAdder();
	}

	@Override
	public void count() {
		la.increment();
	}
}
