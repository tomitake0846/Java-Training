package ch01.ex07;

public class ImproveFibonacci {

	static final int MAX_INDEX = 9;

	public static void main(String[] args) {

		/**
		 * 偶数要素に'*'を付けて、フィボナッチ数列の
		 * 最初の方の要素を表示する
		 * */
		int lo = 1;
		int hi = 1;
		String mark;
		System.out.println("1: " + lo);
		for(int i=MAX_INDEX; i>= 2; i--) {
			if(hi % 2 ==0) {
				mark = "*";
			} else {
				mark = "";
			}
			System.out.println( (MAX_INDEX - ( i - 2 ) ) +  ": " + hi + mark);
			hi = lo + hi;// new hi
			lo = hi - lo;// new "lo" is calculated (sum ^ old "lo")
		}
	}
}
