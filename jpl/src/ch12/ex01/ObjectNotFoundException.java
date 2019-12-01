package ch12.ex01;

public class ObjectNotFoundException extends Exception{
	public ObjectNotFoundException() {
		super("Object not found.");
	}
	public ObjectNotFoundException(String errMsg) {
		super(errMsg);
	}
}
