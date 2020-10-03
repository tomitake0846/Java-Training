package sample;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Map<Integer,String> idToName = Arrays.stream(getPersons())
				.collect(Collectors.toMap(
						Person::getId ,
						Person::getName,
						(oldValue,newValue) -> oldValue));//古い値を優先する
		Map<String,Long> test = Arrays.stream(getPersons())
				.collect(Collectors.groupingBy(Person::getRoll,
						Collectors.mapping(Person::getRoll, Collectors.counting())));

		for(String roll : test.keySet() ) {
			System.out.println("roll :"+roll);
			System.out.println(test.get(roll).toString());
		}
	}
	private static Person[] getPersons() {
		Person[] people = new Person[5];
		people[0] = new Person(0,"taro","development");
		people[1] = new Person(1,"jiro","development");
		people[2] = new Person(2,"saburo","operation");
		people[3] = new Person(3,"shiro","administration");
		people[4] = new Person(4,"goro","administration");

		return people;
	}
}

class Person {
	private int id;
	private String name;
	private String secret;
	private String roll;
	public Person(int id,String name,String roll) {
		this.id = id;
		this.name = name;
		this.roll = roll;
	}
	public Person(int id, String name,String roll, String secret) {
		this(id,name,roll);
		this.secret = secret;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getRoll() {
		return this.roll;
	}
	public String getSecret() {
		return this.secret;
	}
	public String toString() {
		return "[" + this.id + ":"+this.name+"]";
	}
	public boolean isAdministrator() {
		return this.roll.equals("administration");
	}
}