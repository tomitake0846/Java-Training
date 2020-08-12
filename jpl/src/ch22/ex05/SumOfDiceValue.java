package ch22.ex05;

import java.util.ArrayList;
import java.util.List;

public class SumOfDiceValue {

	public int[] getCountArray(int[] array) {
		Tail tail = new Tail();
		Head head = new Head(array.length);
		List<Integer> list = new ArrayList<Integer>();
		int from=0;
		int to=0;
		while( from < array.length ) {
			from = tail.getTail();
			to = head.getHead();
			int sum=0;
			for(int i = from; i <= to; i++) {
				sum += array[i];
			}
			if(sum != 0) {
				list.add(sum);
			}
		};
		return toArray(list);
	}

	private int[] toArray(List<Integer> list) {
		int[] ary = new int[list.size()];
		for(int i=0;i<ary.length;i++) {
			ary[i] = list.get(i);
		}
		return ary;
	}


	private class Tail {
		private int tail;
		private Tail() {
			this.tail = -5;
		}
		int getTail() {
			if(tail < 0) {
				tail++;
				return 0;
			} else {
				return this.tail++;
			}
		}
	}

	private class Head {
		private int head;
		private int max;
		private Head(int max) {
			this.head = 0;
			this.max = max -1;
		}
		int getHead() {
			if(this.head < max) {
				return this.head++;
			} else {
				head++;
				return max;
			}
		}
	}
}
