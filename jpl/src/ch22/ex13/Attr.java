package ch22.ex13;

public class Attr<E> {
	private final String name;
	private E value = null;
	public Attr(String name) {
		this.name = name;
	}
	public Attr(String name,E value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}
	public E getValue() {
		return this.value;
	}
	public E setValue(E newValue) {
		E oldValue = this.value;
		this.value = newValue;
		return oldValue;
	}
	public String toString() {
		return name+"='" + value +"'";
	}

}
