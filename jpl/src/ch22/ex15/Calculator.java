package ch22.ex15;

public class Calculator {
	public static void main(String[] args) {
		ConcurrentGreeter c = new ConcurrentGreeter();
		c.greet();
	}
}
class Greeter {
	public void greet() {
		System.out.println("hello");
	}
}

class ConcurrentGreeter extends Greeter {
	public void greet() {
		Thread t = new Thread(super::greet);
		t.start();
	}
}