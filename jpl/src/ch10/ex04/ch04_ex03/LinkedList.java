package ch10.ex04.ch04_ex03;

public class LinkedList implements Cloneable , List{
	private Node head;
	private Node tail;

	/*LinkedList's field has already been private.*/

	public void add(Object value) {
		/*create a new LInkedList instance and set the value.*/
		Node node = new Node(value);
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNextNode(node);
			this.tail = node;
		}
	}

	public Object get(int index) {
		index --;
		if(index < 0 ) {
			return null;
		}
		Node dummy = this.head;

//		for(int i=0;i<index;i++) {
//			if(!dummy.hasMoreElement()) {
//				return null;
//			}
//			dummy = dummy.next;
//		}
//
//		return dummy.getValue();


		//while
		int i = 0;
		while(i < index) {
			if(!dummy.hasMoreElement()) {
				return null;
			}
			dummy = dummy.next;
			i++;
		}

		//do-while
//		do {
//			if(!dummy.hasMoreElement()) {
//				return null;
//			}
//			dummy = dummy.next;
//			i++;
//		}while(i < index);

		/*while,do-whileで記述すべきではない。
		 *ループ回数はindex回と決まっているため、for文が適切。
		 * */

		return dummy.getValue();
	}

	public int count() {
		int count=0;
		Node dummy = this.head;

		if(dummy != null) {
			count++;
		} else {
			return count;
		}

		while(dummy.hasMoreElement()) {
			dummy = dummy.next;
			count ++;
		}

		return count;
	}

	@Override
	public Object clone() {
		LinkedList cloneList = new LinkedList();
		int i= 1;
		Object value;
		while( (value = get(i)) != null) {
			cloneList.add(value);
			i++;
		}
		return cloneList;
	}


	private static class Node {
		private Object value;
		private Node next;
		private Node(Object value) {
			this.value = value;
		}

		public Object getValue() {
			return this.value;
		}

		public void setNextNode(Node next) {
			this.next = next;
		}

		/*if LInkedList has "next" . it returns true.*/
		public boolean hasMoreElement() {
				return this.next != null;
		}
	}
}
