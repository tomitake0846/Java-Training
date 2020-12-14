package ch03.ex23;

public class Pair <T>{
	private T t;
	private String u;

	public Pair(T t) {
		this.t = t;
		this.u = t.toString();
	}

	public T getOrigin() {
		return this.t;
	}
	public String getPair() {
		return this.u;
	}

}
