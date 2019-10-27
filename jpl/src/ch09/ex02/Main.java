package ch09.ex02;

public class Main {
	public static void main(String[] args) {
		BitCounter counter = new BitCounter();
		System.out.println("1 : " + counter.BitCount(1));//1
		System.out.println("2 : " + counter.BitCount(2));//1
		System.out.println("3 : " + counter.BitCount(3));//2
		System.out.println("4 : " + counter.BitCount(4));//1
		System.out.println("10 : " + counter.BitCount(-1));//3
	}
}
