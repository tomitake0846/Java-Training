package ch06.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

public class Accumulator {

	private final LongAccumulator la;

	public Accumulator(LongBinaryOperator lbo,long initValue) {
		this.la = new LongAccumulator(lbo,initValue);
	}

	public long get(List<Integer> list) {
		ExecutorService es = Executors.newFixedThreadPool(10);

		List<Callable<Integer>> l = new ArrayList<>(list.size());
		for(int i : list) {
			l.add(() -> {
				la.accumulate(i);
				return 1;
			});
		}
		try {
			es.invokeAll(l);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		es.shutdown();

		return la.get();
	}
}
