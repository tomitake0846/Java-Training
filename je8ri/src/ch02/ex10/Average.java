package ch02.ex10;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Average {
	public double getAverage(Stream<Double> stream) {

		BiFunction<node,Double,node> bif = (a,v) -> {
			a.add(v);
			return a;
		};

		return stream.reduce(new node(),
				bif,
				(e1,e2) -> e1).ave();
	}

	private class node {
		double a = 0;
		int count = 0;
		void add(double v) {
			a += v;
			count++;
		}
		double ave() {
			return a / count;
		}
	}
}
