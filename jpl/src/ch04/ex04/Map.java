package ch04.ex04;

public interface Map extends Collection{
	void put(Object key,Object value);
	boolean containsKey(Object key);
	Object get(Object key);
}
