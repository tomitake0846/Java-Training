package ch03.ex03;

public class Y extends X{
	protected int yMask = 0xff00;

	public Y() {
		fullMask |= yMask;
	}
	public static void main(String[] args) {
		Y y = new Y();
		X x = new X();
		System.out.printf("%x\n",x.mask(0xaaaa));
		System.out.printf("%x\n",y.mask(0xaaaa));
	}
}
