package ch08.ex06;

import java.util.Comparator;

public class Rectangle2D{
	private int x;
	private int y;
	public Rectangle2D(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int gexX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	public int area() {
		return x * y;
	}

	public static Comparator<Rectangle2D> compare() {
		return (r1,r2) -> {
			if (r1.area() > r2.area()) {
				return 1;
			} else if (r1.area() == r2.area()) {
				return 0;
			} else {
				return -1;
			}
		};
	}

}
