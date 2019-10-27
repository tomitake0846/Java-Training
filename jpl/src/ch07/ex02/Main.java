package ch07.ex02;

public class Main {

	private static Numbers numbers = new Numbers();

	private static char c=0;
	private static byte b=0;
	private static short s=0;
	private static int i=0;
	private static long l=0;
	private static float f=0;
	private static double d=0;

	public static void main(String[] args) {
		charTest();
		byteTest();
		shortTest();
		intTest();
		longTest();
		floatTest();
		doubleTest();
	}

	public static void charTest() {
		numbers.c = c;
//		numbers.c = b; //Type mismatch
//		numbers.c = s; //Type mismatch
//		numbers.c = i; //Type mismatch
//		numbers.c = l; //Type mismatch
//		numbers.c = f; //Type mismatch
//		numbers.c = d; //Type mismatch
	}

	public static void byteTest() {
//		numbers.b = c; //Type mismatch
		numbers.b = b;
//		numbers.b = s; //Type mismatch
//		numbers.b = i; //Type mismatch
//		numbers.b = l; //Type mismatch
//		numbers.b = f; //Type mismatch
//		numbers.b = d; //Type mismatch
	}

	public static void shortTest() {
//		numbers.s = c; //Type mismatch
		numbers.s = b;
		numbers.s = s;
//		numbers.s = i; //Type mismatch
//		numbers.s = l; //Type mismatch
//		numbers.s = f; //Type mismatch
//		numbers.s = d; //Type mismatch
	}

	public static void intTest() {
		numbers.i = c;
		numbers.i = b;
		numbers.i = s;
		numbers.i = i;
//		numbers.i = l; //Type mismatch
//		numbers.i = f; //Type mismatch
//		numbers.i = d; //Type mismatch
	}

	public static void longTest() {
		numbers.l = c;
		numbers.l = b;
		numbers.l = s;
		numbers.l = i;
		numbers.l = l;
//		numbers.l = f; //Type mismatch
//		numbers.l = d; //Type mismatch
	}

	public static void floatTest() {
		numbers.f = c;
		numbers.f = b;
		numbers.f = s;
		numbers.f = i;
		numbers.f = l;
		numbers.f = f;
//		numbers.f = d; //Type mismatch
	}

	public static void doubleTest() {
		numbers.d = c;
		numbers.d = b;
		numbers.d = s;
		numbers.d = i;
		numbers.d = l;
		numbers.d = f;
		numbers.d = d;
	}

}
