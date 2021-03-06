package ch02.ex17;

public class Vehicle {

	public static final Angle TURN_LEFT = new Angle(-90);
	public static final Angle TURN_RIGHT = new Angle(90);

	private float speed;
	private int angle;
	private String owner;
	private int id;
	private static int nextId = 0;

	/*Vehicle's field has already been private.*/
	public Vehicle(String owner) {
		this.speed = 0;
		this.angle = 0;
		this.owner = owner;
		id = nextId;
		Vehicle.nextId++;
	}
	public Vehicle() {
		this.speed = 0;
		this.angle = 0;
		id = nextId;
		Vehicle.nextId++;
	}

	public void changeSpeed(float speed) {
		//if speed smaller than 0, speed substitutes 0.
		if (speed <= 0) {
			this.speed = 0;
		} else {
			this.speed = speed;
		}
	}

	public void stop() {
		this.speed = 0;
	}

	public void setAngle(int angle) {
		//if angle smaller than 0. angle substitutes 0.
		if(angle < 0) {
			angle = 0;
		}
		//if angle grater than 360, angle substitutes 360.
		if(360 < angle) {
			angle = 360;
		}
		this.angle = angle;
	}

	public void turn(int angle) {
		int dummy = this.angle + angle;

		if(dummy >= 360) {
			dummy %= 360;
		}

		if(dummy <0) {
			dummy += 360;
		}
		this.angle = dummy;
	}

	public void turn(Angle angle) {
		turn(angle.getAngle());
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("owner : ");
		sb.append(getOwner());
		sb.append("\nspeed : ");
		sb.append(getSpeed());
		sb.append("\nangle : ");
		sb.append(getAngle());
		sb.append("\nid : " );
		sb.append(getId());
		sb.append("\n");
		return sb.toString();
	}

	public float getSpeed() {
		return this.speed;
	}
	public int getAngle() {
		return this.angle;
	}
	public String getOwner() {
		return owner;
	}
	public int getId() {
		return id;
	}
	public static int getMaximumId() {
		return nextId - 1;
	}

	final static class Angle {
		private int angle;
		private Angle(int angle) {
			this.angle = angle;
		}
		int getAngle() {
			return this.angle;
		}
	}
}
