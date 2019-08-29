package ch02.ex02;

public class LinkedList {
	private Object value;
	private LinkedList next;
	private static LinkedList head;
	private static LinkedList tail;

	public void add(Object value) {
		this.value = value;
		LinkedList next = new LinkedList();
		this.next = next;
		LinkedList.tail = next;
	}
	public Object remove() {
		Object object = head.getValue();
		LinkedList.head = LinkedList.head.next;
		return object;
	}
	public Object getValue() {
		return this.value;
	}

	public boolean contains (Object value) {
		LinkedList dummy =
	}

	public boolean hasMoreElement() {
		if (this.next == null) {
			return false;
		} else {
			return true;
		}
	}
	public LinkedList clone(LinkedList target) {
		LinkedList dummy = new LinkedList();
		dummy.value = target.value;
	}
}
