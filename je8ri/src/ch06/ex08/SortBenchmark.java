package ch06.ex08;

import java.util.Arrays;

public class SortBenchmark {
	public static void main(String[] args) {
		int size = 2;
		while(test(size)) {
			size = size << 1;
		}
	}

	public static boolean test(int arraySize) {
		int[] ary1 = generateRandomArray(arraySize);
		int[] ary2 = deepCopy(ary1);

		long s = sort( () -> Arrays.sort(ary1) );
		long ps = sort( () -> Arrays.parallelSort(ary2));

		System.out.println("arraySize :"+arraySize);
		System.out.println("Arrays.sort         :"+s);
		System.out.println("Arrays.ParallelSort :"+ps);
		System.out.println();

		return s <= ps;

	}

	private static long sort(Runnable r) {
		long start = System.currentTimeMillis();
		long end;
		r.run();
		end = System.currentTimeMillis();
		return end - start;
	}

	private static int[] generateRandomArray(int arraySize) {
		int[] ary = new int[arraySize];
		for(int i=0;i<ary.length;i++) {
			ary[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		return ary;
	}
	private static int[] deepCopy(int[] ary) {
		int[] result = new int[ary.length];

		for(int i=0;i<result.length;i++) {
			result[i] = ary[i];
		}

		return result;
	}
}
