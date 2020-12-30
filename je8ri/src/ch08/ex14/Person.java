package ch08.ex14;

import java.util.Objects;

public class Person {
	private String name;
	public Person(String name) {
		//Conventional code
//		if(name == null) {
//			throw new NullPointerException("variable 'name' is null");
//		}
//		this.name = name;

		//NonNull code
		//this code equals the above code.
		this.name = Objects.requireNonNull(name,"In Person class constractor, variable 'name' is null");
	}
}
