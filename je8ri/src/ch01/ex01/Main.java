package ch01.ex01;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Record[] records = new Record[5];
		for(int i=0;i<records.length;i++) {
			int x = (int)(Math.random() * 10);
			records[i] = new Record("xxxid:"+x,""+x);
		}
		System.out.println("Main Thread id :"+Thread.currentThread().getId());
		System.out.println("before sort.");
		System.out.println(Arrays.toString(records));

		Arrays.sort(records,new RecordComparator());

		System.out.println("after sort.");
		System.out.println(Arrays.toString(records));
	}

}
