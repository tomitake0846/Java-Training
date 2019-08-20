package ch01.ex10;

public class ImproveFibonacci {
	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		/**
		 * 偶数要素に'*'を付けて、フィボナッチ数列の
		 * 最初の方の要素を表示する
		 * */
		FibParam lo = new FibParam(1);
		FibParam  hi = new FibParam(1);
		int index;
		FibParam[] array = new FibParam[MAX_INDEX];
		array[0]=lo;
		array[1]=hi;

		for(int i=MAX_INDEX; i> 2; i--) {
			index =  (MAX_INDEX - ( i - 2 ) );
			hi = new FibParam(lo.getValue() + hi.getValue());// new hi
			lo = new FibParam(hi.getValue() - lo.getValue());// new "lo" is calculated (sum ^ old "lo")
			array[index] = hi;
		}

		String mark;
		for(int i=0;i<array.length;i++) {
			if(array[i].isEvenNum()) {
				mark = "*";
			} else {
				mark = "";
			}
			System.out.println(i +  ": " + array[i] + mark);
		}
	}
}
