package ch06.ex03;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongBench implements BenchMarkTarget{

	private AtomicLong al;

	public AtomicLongBench() {
		this.al = new AtomicLong();
	}

	@Override
	public void count() {
		al.incrementAndGet();
	}

}
