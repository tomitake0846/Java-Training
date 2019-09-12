package ch02.ex08;

import ch02.ex05.Vehicle;

public class LinkedList {
	private Object value;
	private LinkedList next;
	private static LinkedList HEAD;
	private static LinkedList TAIL;

	public LinkedList(Object value) {
		add(value);
	}
	public LinkedList() {};

	public void add(Object value) {
		/*create a new LInkedList instance and set the value.*/
		LinkedList item = new LinkedList();
		item.value = value;
		if(LinkedList.HEAD == null) {
			LinkedList.HEAD = item;
			LinkedList.TAIL = item;
		} else {
			LinkedList.TAIL.next = item;
			LinkedList.TAIL = item;
		}
	}

	public LinkedList getNode(int index) {
		index --;
		if(index < 0 ) {
			return null;
		}
		LinkedList dummy = LinkedList.HEAD;
		for(int i=0;i<index;i++) {
			if(!dummy.hasMoreElement()) {
				return null;
			}
			dummy = dummy.next;
		}
		return dummy;
	}

	public Object getValue() {
		return this.value;
	}

	/*if LInkedList has "next" . it returns true.*/
	private boolean hasMoreElement() {
		return this.next != null;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Vehicle("Tom"));
		list.add(new Vehicle("Alice"));
		System.out.println(list.getNode(1).getValue());
		System.out.println(list.getNode(2).getValue());
		list.add(new Vehicle("Bob"));
		System.out.println(list.getNode(3).getValue());
	}

}
