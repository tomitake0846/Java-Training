package ch08.ex08;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyDeque{
	protected Queue<? extends Super> q;
	public MyDeque() {
		this.q = new ArrayDeque<>();
	}

	public boolean add(Object e) {
		return false;
//		return this.q.add(e);
	}
}
