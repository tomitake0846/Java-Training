package ch12.ex01;

public class LinkedList implements Cloneable{
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
		for(int i=0;i<index;i++) {
			if(!dummy.hasMoreElement()) {
				return null;
			}
			dummy = dummy.next;
		}
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

	public LinkedList find(Object target) throws ObjectNotFoundException{
		if(this.head == null) {
			throw new ObjectNotFoundException("head is null.Maybe this LinkedList hasn't element.");
		}

		Node node = this.head;

		while(true){
			if(node.getValue().equals(target)) {
				break;
			}
			if(node.hasMoreElement()) {
				node = node.next;
			} else {
				throw new ObjectNotFoundException();
			}
		}

		LinkedList result = new LinkedList();
		result.add(node.getValue());
		return result;
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
