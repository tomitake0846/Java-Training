package ch09.ex08;

public class Point implements Comparable<Point>{
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point other) {
		int xc = compare(x,other.x);
		if(xc != 0) {
			return xc;
		}
		return compare(y,other.y);
	}

	private int compare(int v1, int v2) {
		if(v1 < v2) {
			return -1;
		} else if (v1 == v2) {
			return 0;
		} else {
			return 1;
		}
	}
}
