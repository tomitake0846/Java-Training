package ch06.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BenchMark {

	private final int THREAD_SIZE = 1000;
	private List<Callable<Integer>> list;
	private BenchMarkTarget t;

	public BenchMark(BenchMarkTarget t) {
		this.t = t;
		listInit();
	}

	public long start() {
		long start = System.currentTimeMillis();
		long end;

		ExecutorService pool = Executors.newFixedThreadPool(THREAD_SIZE);
		try {
			pool.invokeAll(list);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		pool.shutdown();

		end = System.currentTimeMillis();

		return end - start;
	}

	private void listInit() {
		list = new ArrayList<>(THREAD_SIZE);
		for(int i=0;i<THREAD_SIZE;i++) {

			list.add(() -> {
				for(int j=0;j<100000;j++) {
						t.count();
				}
				return 1;
			});

		}
	}
}
