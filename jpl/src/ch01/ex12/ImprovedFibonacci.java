package ch01.ex12;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		/**
		 * 偶数要素に'*'を付けて、フィボナッチ数列の
		 * 最初の方の要素を表示する
		 * */
		int lo = 1;
		int hi = 1;
		String mark;
		String[] array = new String[MAX_INDEX];
		array[0] = new String("1: " + lo);
		for(int i=2; i<= MAX_INDEX; i++) {
			if(hi % 2 ==0) {
				mark = "*";
			} else {
				mark = "";
			}
			array[i-1] =  new String(i +  ": " + hi + mark);
			hi = lo + hi;// new hi
			lo = hi - lo;// new "lo" is calculated (sum ^ old "lo")
		}
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}