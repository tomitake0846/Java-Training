package ch13.ex05;

public class Comma {
	//...cheat?
	public String transrate(String target) {
		return String.format("%,d",Integer.parseInt(target));
	}
}
