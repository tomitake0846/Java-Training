package ch02.ex02;

public class LinkedList {
	private Object value;
	private LinkedList next;
	private static LinkedList HEAD;
	private static LinkedList TAIL;
	public void add(Object value) {
		/*create a new LInkedList instance and set the value.*/
		LinkedList item = new LinkedList();
		item.value = value;
		if(LinkedList.HEAD == null) {
			LinkedList.HEAD = item;
			LinkedList.TAIL = item;
		} else {
			LinkedList.TAIL.next = item;
		}
	}

	public static LinkedList getNode(int index) {
		index --;
		if(index < 0 ) {
			return null;
		}
		LinkedList dummy = LinkedList.HEAD;
		for(int i=0;i<index;i++) {
			System.out.println(i);
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
	public boolean hasMoreElement() {
		return this.next != null;
	}
}
