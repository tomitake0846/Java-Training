package ch02.ex02;

public class LinkedList {
	private Object value;
	private LinkedList next;
	private static LinkedList head;
	private static LinkedList tail;

	static {
		LinkedList item = new LinkedList();
		LinkedList.head = item;
		LinkedList.tail = item;
	}

	public void add(Object value) {
		/*create a new LInkedList instance and set the value.*/
		LinkedList item = new LinkedList();
		item.value = value;

		/*set "next" for current" tail"*/
		LinkedList.tail.next = item;
		LinkedList.tail = item;
		System.out.println(item.toString());
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
		LinkedList dummy = LinkedList.head;
		while(dummy.hasMoreElement()) {
			Object val = dummy.getValue();
			if(val.equals(value) ) {
				return true;
			}
			dummy = dummy.next;
		}
		return false;
	}

	/*if LInkedList has "next" . it returns true.*/
	public boolean hasMoreElement() {
		return this.next != null;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		LinkedList dummy = LinkedList.head;
		while(dummy.hasMoreElement()) {
			builder.append(dummy.getValue() + " ");
			dummy = dummy.next;
		}
		builder.append("]");
		return builder.toString();
	}
}
