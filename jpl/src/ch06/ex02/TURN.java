package ch06.ex02;

public enum TURN {
	TURN_RIGHR(90),
	TURN_LEFT(-90);

	private final int angle;

	private TURN(int angle) {
		this.angle = angle;
	}

	public int getAngle( ) {
		return this.angle;
	}
}
