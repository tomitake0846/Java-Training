package ch02.ex04;

public class Vehicle {
	private float speed;
	private int angle;
	private String owner;
	private int id;

	/*
	 * 解答
	 * nextIdに、final修飾子は付与すべきでない
	 * 理由
	 * nextIdを変更不能にすると、車固有のIDが全て同じになる。
	 * その場合、「車を一意に識別できる」という役割を果たせなくなる。
	 * */
	private static int nextId = 0;
	public Vehicle(String owner) {
		this.speed = 0;
		this.angle = 0;
		this.owner = owner;
		id = nextId;
		Vehicle.nextId++;
	}

	public void setSpeed(float speed) {
		//if speed smaller than 0, speed substitutes 0.
		if (speed <= 0) {
			this.speed = 0;
		} else {
			this.speed = speed;
		}
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
}
