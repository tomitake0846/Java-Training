package ch01.ex09;

public class Fibonacci {
	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		/**
		 * 偶数要素に'*'を付けて、フィボナッチ数列の
		 * 最初の方の要素を表示する
		 * */
		int lo = 1;
		int hi = 1;
		int[] array = new int[MAX_INDEX];
		array[0] = lo;
		array[1] = hi;
		for(int i=2; i< MAX_INDEX; i++) {
			hi = lo + hi;// new hi
			lo = hi - lo;// new "lo" is calculated (sum ^ old "lo")
			array[i] = hi;
		}
		for(int i=0;i<array.length;i++) {
			System.out.println( (i +1) + ": " + array[i]);
		}
	}
}
