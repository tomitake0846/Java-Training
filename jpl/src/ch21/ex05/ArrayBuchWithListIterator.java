package ch21.ex05;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayBuchWithListIterator<E> implements ListIterator<E>{
	private final E[][] arrays;
	private final int size;
	private int off;
	private int array;
	private int pos;

	public ArrayBuchWithListIterator(E[][] arrays) {
		this.arrays = arrays.clone();
		int s = 0;
		for (E[] array : arrays) {
			s += array.length;
		}
		this.size = s;
		off=0;
		array=0;
		pos=0;
		for(array = 0;array < arrays.length;array++) {
			if(arrays[array].length > 0) {
				break;
			}
		}
	}

	@Override
	public boolean hasNext() {
		return off + pos > size();
	}

	public int size() {
		return size;
	}

	//TODO 実装を変える？
	public E get(int index) {

		int off = 0;
		for(int i=0;i<arrays.length;i++) {
			if (index < off + arrays[i].length) {
				return arrays[i][index - off];
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	//TODO 実装を変える？
	public E set(int index, E value) {
		int off = 0;
		for(int i=0;i<arrays.length;i++) {
			if (index < off + arrays[i].length) {
				E ret = arrays[i][index - off];
				arrays[i][index - off] = value;
				return ret;

			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	@Override
	public E next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		E ret = arrays[array][pos++];

		while(pos >= arrays[array].length) {
			off += arrays[array++].length;
			pos = 0;
			if (array >= arrays.length) break;
		}

		return ret;
	}

	@Override
	public boolean hasPrevious() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E previous() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int nextIndex() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int previousIndex() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();

	}

	@Override
	public void set(E e) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void add(E e) {
		throw new UnsupportedOperationException();

	}
}
