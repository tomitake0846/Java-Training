package ch09.ex09;

public class LabeledPoint {
	private String label;
	private int x;
	private int y;
	public LabeledPoint(int x,int y) {
		this.x = x;
		this.y = y;
		this.label = "";
	}

	public void labeled(String label) {
		this.label = label;
	}

	public String toString() {
		return "label:[" + this.label + "] :("+this.x+","+this.y+")";
	}

	public int hashCode() {
		return toString().hashCode();
	}
}
