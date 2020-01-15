package ch14.ex02;

public class SingleLinkQueue <E>{
	protected Cell<E> head;
	protected Cell<E> tail;
	private int size = 0;

	public void add(E item) {
		Cell<E> cell = new Cell<E>(item);
		if(tail == null) {
			head = cell;
			tail = cell;
		} else {
			tail.setNext(cell);
			tail = cell;
		}
		size++;
	}

	public E remove() {
		if(head == null) {
			return null;
		}

		Cell<E> cell = head;

		head = head.getNext();
		if(head == null) {
			tail = null;//空のキュー?
		}
		size--;
		return cell.getElement();
	}

	public int size() {
		return this.size;

	}
}
