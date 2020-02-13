package ch17.ex01;

public class Main {

	public static void main(String[] args) {
		MemoryManager mm = new MemoryManager();
		System.out.println(mm.getCurrentFreeMemory());

		String[] array = test();
		System.out.println(mm.getCurrentFreeMemory());

		String[] ary = test();
		System.out.println(mm.getCurrentFreeMemory());

		array=null;
		mm.callGC();
		System.out.println(mm.getCurrentFreeMemory());

		ary=null;
		mm.callGC();
		System.out.println(mm.getCurrentFreeMemory());
	}

	public static String[] test() {
		int n=1000000;
		String[] array = new String[n];
		for(int i=0;i<n;i++) {
			array[i] = "" + i;
		}
		return array;
	}

}
