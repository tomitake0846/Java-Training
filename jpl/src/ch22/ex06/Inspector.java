package ch22.ex06;

import java.util.Random;

public class Inspector {
	private int N;
	private int precision;
	private int[] histogram;
	private Random r;
	public Inspector (int N,int precision) {
		this.N = N;
		this.precision = precision;
		this.histogram = new int[precision];
		this.r = new Random();
	}

	public void run() {
		for(int i=0;i<N;i++) {
			int value = getRandom();
			histogram[value]++;
		}
	}

	public void result() {
		for(int i=0;i<histogram.length;i++) {
			System.out.println(i+":"+astar(histogram[i]));
		}
	}

	private String astar(int x) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<x;i++) {
			sb.append("*");
		}
		return sb.toString();
	}

	private int getRandom() {
		int value = (int) (r.nextGaussian() * Math.sqrt(precision)) + (precision / 2);
		if(value < 0) {
			return 0;
		}
		if(value >= precision) {
			return precision -1;
		}

		return value;
	}
}
