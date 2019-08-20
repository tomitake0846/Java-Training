package ch01.ex10;

public class FibParam {

	private int value;
	private boolean isEvenNum;
	public FibParam(int value) {
		this.value = value;
		this.isEvenNum = ((value % 2) == 0 );
	}

	public int getValue() {
		return this.value;
	}
	public boolean isEvenNum() {
		return this.isEvenNum;
	}
	public String toString() {
		return "" + value;
	}
}
