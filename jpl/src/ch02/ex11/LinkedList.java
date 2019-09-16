package ch02.ex11;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		LinkedList item;

		int i=1;

		while((item = getNode(i)) != null) {
			sb.append(item.getValue());
			sb.append(",");
			i++;
		}
		sb.append("]");
		return sb.toString();
	}

	/*if LInkedList has "next" . it returns true.*/
	private boolean hasMoreElement() {
		return this.next != null;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
	}
}
