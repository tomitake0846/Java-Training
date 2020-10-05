package ch01.ex01;

public class Record {
	private String id;
	private String name;

	public Record(String id,String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		return id + " : " + name;
	}
}
