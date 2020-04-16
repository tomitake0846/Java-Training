package ch22.ex01;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Float[] ary = {
				1.2345678904797439f,
				2.43325323f,
				56784.4345336734f,
				12455.53456676323234253454289f,
				-45639.435323469838f
		};
		print(ary,2);
		System.out.println();
		print(ary,3);

		System.out.println();
		print(ary,5);

	}
	public static void print(Float[] ary , int printLineNum) {
		for(int i=0;i<printLineNum;i++) {
//			System.out.printf("%04.80f\n",ary[i]);
			System.out.println(String.format("%80.60f", ary[i]));
		}
	}
}
