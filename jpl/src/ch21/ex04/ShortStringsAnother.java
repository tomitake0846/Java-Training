package ch21.ex04;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStringsAnother implements ListIterator<String>{
	private Iterator<String> strings;
	private String nextShort;
	private final int maxLen;

	public ShortStringsAnother(Iterator<String> strings,int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		this.nextShort = null;
	}

	@Override
	public boolean hasNext() {
		if(nextShort != null) {
			return true;
		}

		while(strings.hasNext()) {
			nextShort = strings.next();
			if(nextShort.length() <= maxLen) {
				return true;
			}
		}
		nextShort = null;
		return false;
	}

	@Override
	public String next() {
		if(nextShort == null && !hasNext()) {
			throw new NoSuchElementException();
		}
		String n = nextShort;
		nextShort = null;
		return n;
	}

	@Override
	public boolean hasPrevious() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String previous() {
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
	public void set(String e) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void add(String e) {
		throw new UnsupportedOperationException();

	}

}
