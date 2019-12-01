package ch11.ex01;

public class LinkedList<E> implements Cloneable{
	private Node<E> head;
	private Node<E> tail;

	/*LinkedList's field has already been private.*/

	public void add(E value) {
		/*create a new LInkedList instance and set the value.*/
		Node<E> node = new Node<E>(value);
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNextNode(node);
			this.tail = node;
		}
	}

	// The index of get method starts 1,not 0.
	// LinkedList<hoge> list = new LinkedList();
	// list.add(hoge);
	// list.get(0) // bad
	// list.get(1) // return hoge

	public E get(int index) {
		index --;
		if(index < 0 ) {
			return null;
		}

		//The case that if User has never called add method.
		if(this.head == null) {
			return null;
		}

		Node<E> dummy = this.head;
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
		Node<E> dummy = this.head;

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
	public LinkedList<E> clone() {
		LinkedList<E> cloneList = new LinkedList<E>();
		int i= 1;
		E value;
		while( (value = get(i)) != null) {
			cloneList.add(value);
			i++;
		}
		return cloneList;
	}


	private static class Node <E>{
		private E value;
		private Node<E> next;
		private Node(E value) {
			this.value = value;
		}

		public E getValue() {
			return this.value;
		}

		public void setNextNode(Node<E> next) {
			this.next = next;
		}

		/*if LInkedList has "next" , it returns true.*/
		public boolean hasMoreElement() {
				return this.next != null;
		}
	}
}
