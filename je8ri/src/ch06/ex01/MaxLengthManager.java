package ch06.ex01;

import java.util.concurrent.atomic.AtomicLong;

public class MaxLengthManager {

	private AtomicLong largest;

	public MaxLengthManager() {
		largest = new AtomicLong();
	}

	public long update(String str) {
		return largest.accumulateAndGet(str.length(), Math::max);
	}

	public long get() {
		return this.largest.get();
	}
}
