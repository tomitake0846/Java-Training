package ch02.ex01;

import java.util.Arrays;

public class WordCounter {
	public int count(String[] ary) {
		//before
//		int count = 0;
//		for(String w: ary) {
//			if (w.length() > 12) count ++;
//		}
//		return count;

		//after

		return (int)Arrays.stream(ary).parallel().
				filter(s -> s.length() > 12).
				count();
	}
}
