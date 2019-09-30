package ch03.ex09;

import java.util.ArrayList;
import java.util.List;

import ch03.ex08.Vehicle;

public class Garage implements Cloneable{
	private List<Vehicle> list;

	public Garage() {
		this.list  = new ArrayList<Vehicle>();
	}

	public static void main(String[] args) {

	}

	public void add(Vehicle v) {
		this.list.add(v);
	}

	@Override
	public Object clone() {

	}
}
