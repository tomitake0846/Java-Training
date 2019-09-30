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
		Garage g1 = new Garage();
		g1.add(getInstance("alice",30,40));
		g1.add(getInstance("bob",20,70));
		g1.add(getInstance("mike",80,160));
		Garage g2 = (Garage) g1.clone();

		List<Vehicle> g1List = g1.list;
		List<Vehicle> g2List = g2.list;

		for(int i=0;i<g1List.size();i++) {
			Vehicle v1 = g1List.get(i);
			Vehicle v2 = g2List.get(i);
			System.out.println(v1.getId() + " : " + v2.getId()); // different
			System.out.println(v1.getOwner() + " : " + v2.getOwner()); // different
			System.out.println(v1.getAngle() + " : " + v2.getAngle()); // same
			System.out.println(v1.getSpeed() + " : " + v2.getSpeed()); // same
		}

	}

	private static Vehicle getInstance(String owner,float speed,int angle) {
		Vehicle v = new Vehicle(owner);
		v.setAngle(angle);
		v.changeSpeed(speed);
		return v;
	}

	public void add(Vehicle v) {
		this.list.add(v);
	}

	@Override
	public Object clone() {
		Garage garage = new Garage();
		for(Vehicle v : this.list) {
			garage.add((Vehicle) v.clone());
		}

		return garage;
	}

}
