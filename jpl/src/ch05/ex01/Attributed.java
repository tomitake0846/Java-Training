package ch05.ex01;

public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();

	public static class Attr {
		//some code...
	}
}
