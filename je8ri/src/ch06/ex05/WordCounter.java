package ch06.ex05;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordCounter {
	private ConcurrentHashMap<String ,Set<File>> counter;
	private final int THREAD_NUM = 5;
	private List<Callable<Integer>> jobList;

	public WordCounter() {
		this.counter = new ConcurrentHashMap<>();
		jobList = new ArrayList<>();
	}

	public void set(File file) {
		jobList.add(getJob(file));
	}

	public ConcurrentHashMap<String,Set<File>> start() {
		ExecutorService service = Executors.newFixedThreadPool(THREAD_NUM);
		try {
			service.invokeAll(jobList);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return this.counter;
	}

	private Callable<Integer> getJob(File file) {
		return () -> {
			try {
				WordParser wp = new WordParser();
				List<String> list = wp.parseToWordList(file);
				for(String word : list) {
					Set<File> set = new HashSet<>();
					set.add(file);
					counter.merge(word, set,(e,n) -> {e.addAll(n); return e;});
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return 1;
		};
	}
}
