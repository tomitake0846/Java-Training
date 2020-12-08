package ch06.ex01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

class MaxLengthManagerTest {

	@Test
	void test() {
		int n = 10000;
		String[] str = {"1","22","333","4444","55555","666666","7777777","88888888","999999999"};
		for(int i=0;i<n;i++) {
			MaxLengthManager mlm = new MaxLengthManager();
			ExecutorService pool = Executors.newFixedThreadPool(3);
			List<Callable<Long>> list = new ArrayList<>();
			for(String s : str) {
				list.add(() -> mlm.update(s));
			}

			try {
				pool.invokeAll(list);
			} catch (InterruptedException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			pool.shutdown();

			assertEquals(9,mlm.get());

		}
	}

}
