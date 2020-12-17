package ch09.ex10;

public class LabeledPoint implements Comparable<LabeledPoint>{
	private String label;
	private Point point;
	public LabeledPoint(int x,int y) {
		this.point = new Point(x,y);
		this.label = "";
	}

	public void labeled(String label) {
		this.label = label;
	}

	public String toString() {
		return "label:[" + this.label + "] :("+this.point.x()+","+this.point.y()+")";
	}

	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public int compareTo(LabeledPoint o) {
		return point.compareTo(o.point);
	}
}
