package ch01.ex01;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record>{

	public int compare(Record o1, Record o2) {
		System.out.println("Comparator Thread id :"+Thread.currentThread().getId());
		return o1.getId().compareTo(o2.getId());
	}


}
