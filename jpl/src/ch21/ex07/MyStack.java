package ch21.ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack <E>{
	private List<E> list;

	//test ok
	public MyStack(int n) {
		this.list = new ArrayList<E>(n);
	}
	// test ok
	public MyStack() {
		this.list = new ArrayList<E>();
	}
	// test ok
	public void push(E value) {
		list.add(value);
	}


	public E pop() {
		if(list.size() <= 0) {
			throw new EmptyStackException();
		}
		return list.remove(list.size() - 1);
	}

	// test ok
	public E peek() {
		if(list.size() <= 0) {
			throw new EmptyStackException();
		}
		return list.get(list.size()-1);
	}

	public int search(E element) {
		int index = -1;
		if(list.indexOf(element)>=0) {
			index = list.indexOf(element)+1;
		}
		return index;
	}

	//test ok
	public boolean empty() {
		return list.isEmpty();
	}

	//test ok
	public int size() {
		return list.size();
	}
}
