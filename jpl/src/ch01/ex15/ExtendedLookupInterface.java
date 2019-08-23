package ch01.ex15;

public interface ExtendedLookupInterface extends Lookup{
	void add(String name,Object values);
	void remove(String name);
}
