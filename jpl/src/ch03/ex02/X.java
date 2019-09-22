package ch03.ex02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X() {
		fullMask = xMask;
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}

	/*ex3.3
	 * mask用のsetterを別途用意する。
	 * */
	public void setMask(int mask) {
		fullMask = mask;
	}
}
