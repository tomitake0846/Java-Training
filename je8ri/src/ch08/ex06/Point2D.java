package ch08.ex06;

import java.util.Comparator;

public class Point2D{
	private int x;
	private int y;
	public Point2D(int x,int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	public static Comparator<Point2D> compare() {
		return (p1,p2) -> {
			// compare x
			if (p1.x > p2.x) {
				return 1;
			}
			if (p1.x < p2.x) {
				return -1;
			}

			// compare y
			if (p1.y > p2.y) {
				return 1;
			}
			if (p1.y < p2.y) {
				return -1;
			}

			// (p1.x == p2.x) && (p1.y == p2.y)
			return 0;
		};
	}

}
